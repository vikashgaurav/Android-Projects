package com.grv.vikash.smartrip.Activity_Train;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.grv.vikash.smartrip.R;

public class Seat_Map extends AppCompatActivity {
    RelativeLayout sleeper ,acOne, actwo, acthree, ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        methodlistner();

    }

    private void init() {
        sleeper = (RelativeLayout) findViewById(R.id.sleeper);
        acOne = (RelativeLayout) findViewById(R.id.ac1);
        actwo = (RelativeLayout) findViewById(R.id.ac2);
        acthree = (RelativeLayout) findViewById(R.id.ac3);
        ss = (RelativeLayout) findViewById(R.id.seating);

    }

    private void methodlistner() {
        sleeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Seat_Map.this, SleeperMap.class);
                startActivity(i);
            }
        });
        acOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Seat_Map.this, AcOneMap.class);
                startActivity(i);
            }
        });
        actwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Seat_Map.this, AcTwoMap.class);
                startActivity(i);
            }
        });
        acthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Seat_Map.this, AcThreeMap.class);
                startActivity(i);
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Seat_Map.this, SeatingMap.class);
                startActivity(i);
            }
        });
    }

}
