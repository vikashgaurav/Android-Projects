package com.grv.vikash.smartrip.Activity_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class TrainBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_booking);

        getSupportActionBar().setTitle("Book your Trip");

        WebView bookTrain = (WebView) findViewById(R.id.bookTrainWebView);
        bookTrain.loadUrl("https://www.irctc.co.in/eticketing/loginHome.jsf");
    }
}
