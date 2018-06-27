package com.grv.vikash.smartrip.Activity_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class RunningTrain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_train);

        getSupportActionBar().setTitle("Check Train Status");

        WebView runningTrain = (WebView) findViewById(R.id.runningTrainWebView);
        runningTrain.loadUrl("https://www.trainspnrstatus.com/train-running-status");
    }
}
