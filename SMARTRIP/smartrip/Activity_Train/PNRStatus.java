package com.grv.vikash.smartrip.Activity_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.grv.vikash.smartrip.R;

public class PNRStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pnrstatus);

        getSupportActionBar().setTitle("Check PNR Status");

        WebView pnrStatus = (WebView) findViewById(R.id.pnrstatusWebView);
        pnrStatus.loadUrl("https://www.trainspnrstatus.com/");
    }
}
