package com.grv.vikash.smartrip.Activity_Flights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class FareAlerts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fare_alerts);

        getSupportActionBar().setTitle("Fare Alerts");

        WebView fareAlert = (WebView) findViewById(R.id.fareALertsWebView);
        fareAlert.loadUrl("http://www.airfarewatchdog.com/");
    }
}
