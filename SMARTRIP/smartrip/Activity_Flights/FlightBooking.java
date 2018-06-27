package com.grv.vikash.smartrip.Activity_Flights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class FlightBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_booking);

        getSupportActionBar().setTitle("Book your trip");

        WebView FlighBooking = (WebView) findViewById(R.id.FlightBookingwebView);
        FlighBooking.loadUrl("http://www.air.irctc.co.in/IndianRailways/");
    }
}
