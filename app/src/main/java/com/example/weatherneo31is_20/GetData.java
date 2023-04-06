package com.example.weatherneo31is_20;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class GetData extends AsyncTask <URL, Void, String>
{
    private static final String TAG = "GetData";

    protected String getResponseFromHttpsGetURL (URL url) throws IOException
     {
         HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         try
         {
             InputStream in = urlConnection.getInputStream();
             Scanner scanner = new Scanner(in);
             scanner.useDelimiter("\\A");
             boolean hasInput = scanner.hasNext();
             String res;
             if (hasInput)
             {
                 res = scanner.next();
                 return res;
             }
             else
             {
                 return null;
             }
         }
         finally
         {
             urlConnection.disconnect();
         }
    }

    @Override
    protected void onPreExecute()
    {
        Log.d(TAG, "onPreExecute: called");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL[] url)
    {
        Log.d(TAG, "doInBackground: called");
        String result= null;
        URL urlQuery = url[0];
        try
        {
            result = getResponseFromHttpsGetURL(urlQuery);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute (String result)
    {
        Log.d(TAG, "onPostExecute: called");
        Log.d(TAG, "onPostExecute: called" + result);
        // super.onPostExecute(o);
    }
}
