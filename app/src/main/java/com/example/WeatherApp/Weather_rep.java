package com.example.WeatherApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.locationfind.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather_rep extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_rep);
        Intent intent = getIntent();
        String description =intent.getStringExtra("description");
        Double temp = intent.getDoubleExtra("temp",0.0);
        Double feelLike=intent.getDoubleExtra("feelLike",0.0);
        String pressure =intent.getStringExtra("pressure");
        String humidity =intent.getStringExtra("humidity");
        String wind =intent.getStringExtra("wind");
        String wind_degree =intent.getStringExtra("wind_degree");
        long sunrise = intent.getLongExtra("sunrise",0);
        long sunset = intent.getLongExtra("sunset",0);
        Date sunset_time = new Date(sunset * 1000L);
        Date sunrise_time = new Date(sunrise * 1000L);


        TextView details = (TextView) findViewById(R.id.Weather_data);
        String data ="Weather : "+ description+ "\nTemperature : " +new DecimalFormat().format(temp) +"°C\n"
                +"Feels Like : "+new DecimalFormat().format(feelLike)+"°C\nHumidity : " +humidity+ "%\n"
                +"Wind Speed : "+wind+"m/s\n"
                +"Wind Degree : "+wind_degree+"°\n"
                +"Pressure : "+pressure+" hpa\n"
                + "sunrise : "+new SimpleDateFormat("hh:mm").format(sunrise_time)+"AM\n"
                + "sunset : "+new SimpleDateFormat("hh:mm").format(sunset_time)+"PM";
        details.setText(data);
    }

}
