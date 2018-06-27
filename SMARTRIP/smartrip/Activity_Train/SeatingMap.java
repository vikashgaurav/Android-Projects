package com.grv.vikash.smartrip.Activity_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grv.vikash.smartrip.R;

public class SeatingMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seating_map);

        getSupportActionBar().setTitle("Seating");
    }
}
