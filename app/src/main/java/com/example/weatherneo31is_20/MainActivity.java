package com.example.weatherneo31is_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity

{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=650ee86dba40f40f5f1836c801909120");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        new GetData().execute();
    }

}