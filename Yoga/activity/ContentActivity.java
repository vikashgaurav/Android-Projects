package com.cdac.yogalisting.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.cdac.yogalisting.R;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String des = getIntent().getStringExtra("des");

        WebView webView = (WebView) findViewById(R.id.webView);

        webView.loadDataWithBaseURL(null, des, "text/html", "utf-8", null);
    }
}
