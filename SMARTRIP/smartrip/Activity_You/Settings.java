package com.grv.vikash.smartrip.Activity_You;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grv.vikash.smartrip.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle("Settings");
    }
}
