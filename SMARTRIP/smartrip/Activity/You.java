package com.grv.vikash.smartrip.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.grv.vikash.smartrip.Activity_You.Settings;
import com.grv.vikash.smartrip.Activity_You.Support;
import com.grv.vikash.smartrip.ForAdmin.Admin_Login;
import com.grv.vikash.smartrip.R;

public class You extends AppCompatActivity {
    TableLayout trains, flights, bus;
    LinearLayout admin, settings, support, ratefeed, terms, privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);

        init();
        methodlistner();

    }


    private void init() {

        trains = (TableLayout) findViewById(R.id.trains);
        flights = (TableLayout) findViewById(R.id.flights);
        bus = (TableLayout) findViewById(R.id.bus);

        admin = (LinearLayout) findViewById(R.id.admin);
        settings =  (LinearLayout) findViewById(R.id.settings);
        support =  (LinearLayout) findViewById(R.id.support);
        ratefeed =  (LinearLayout) findViewById(R.id.feedback);
        terms =  (LinearLayout) findViewById(R.id.terms);
        privacy =  (LinearLayout) findViewById(R.id.privacy);
    }


    private void methodlistner() {

    trains.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(You.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    });
    flights.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(You.this, Flight.class);
            startActivity(i);
            finish();
        }
    });
    bus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(You.this, Buses.class);
            startActivity(i);
            finish();
        }
    });


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(You.this, Admin_Login.class);
                startActivity(i);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(You.this, Settings.class);
                startActivity(i);
            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(You.this, Support.class);
                startActivity(i);

            }
        });

        ratefeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showfeedbackdailog();
            }
        });
    }

    private void showfeedbackdailog() {

        LayoutInflater  inflater =  (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View dailogView = inflater.inflate(R.layout.feedback_dailogdesign, null);

        TextView love = (TextView) dailogView.findViewById(R.id.lovefeedback);
        TextView notlove = (TextView) dailogView.findViewById(R.id.notlovefeedback);

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(You.this, "Thanks for you feedback", Toast.LENGTH_SHORT).show();
            }
        });

        notlove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(You.this, "Thanks for you feedback", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dailog = new Dialog(You.this);
        dailog.setContentView(dailogView);
        dailog.show();
    }
}
