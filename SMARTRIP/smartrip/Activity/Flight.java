package com.grv.vikash.smartrip.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.grv.vikash.smartrip.Activity_Flights.CabBooking;
import com.grv.vikash.smartrip.Activity_Flights.FareAlerts;
import com.grv.vikash.smartrip.Activity_Flights.FlightBooking;
import com.grv.vikash.smartrip.Activity_Flights.FlightTracker;
import com.grv.vikash.smartrip.Activity_Flights.Search_Flights;
import com.grv.vikash.smartrip.R;

public class Flight extends AppCompatActivity {
    TableLayout trains, bus, you;
    LinearLayout airSearch, flighTrack, airTrip, cabBooking, fareAlerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        init();
        methodlistner();
    }


    private void init() {
        trains = (TableLayout) findViewById(R.id.trains);
        bus = (TableLayout) findViewById(R.id.bus);
        you = (TableLayout) findViewById(R.id.you);

        airSearch = (LinearLayout) findViewById(R.id.airSearch);
        flighTrack = (LinearLayout) findViewById(R.id.airTrack);
        airTrip = (LinearLayout) findViewById(R.id.airTrip);
        cabBooking = (LinearLayout) findViewById(R.id.airCabBooking);
        fareAlerts = (LinearLayout) findViewById(R.id.airFare);

    }

    private void methodlistner() {
        trains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, Buses.class);
                startActivity(i);
                finish();
            }
        });
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, You.class);
                startActivity(i);
                finish();
            }
        });

        airSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this , Search_Flights.class);
                startActivity(i);
            }
        });

        flighTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, FlightTracker.class);
                startActivity(i);
            }
        });

        airTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, FlightBooking.class);
                startActivity(i);
        }
        });

        cabBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, CabBooking.class);
                startActivity(i);
        }
        });

        fareAlerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flight.this, FareAlerts.class);
                startActivity(i);
        }
        });

    }
}
