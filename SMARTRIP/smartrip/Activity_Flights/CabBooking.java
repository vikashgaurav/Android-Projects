package com.grv.vikash.smartrip.Activity_Flights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class CabBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cab_booking);

        getSupportActionBar().setTitle("Book Your cab");

        WebView cabBook = (WebView) findViewById(R.id.cabBookigWebView);
        cabBook.loadUrl("https://www.uber.com/en-IN/");
    }
}
