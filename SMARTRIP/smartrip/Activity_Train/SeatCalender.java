package com.grv.vikash.smartrip.Activity_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class SeatCalender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_calender);

        getSupportActionBar().setTitle("Seat Availability Calender");

        WebView seatcalender = (WebView) findViewById(R.id.seatCalenderWebView);
        seatcalender.loadUrl("http://www.indianrail.gov.in/seat_Avail.html");
    }
}
