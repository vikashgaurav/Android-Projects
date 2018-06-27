package com.grv.vikash.smartrip.ForAdmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grv.vikash.smartrip.R;

public class Admin extends AppCompatActivity {

    Button addTrain, addFlights, addBuses;
    TextView userFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        methodListner();


        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {

        addTrain = (Button) findViewById(R.id.addTrain);
        addFlights = (Button) findViewById(R.id.addFlights);
        addBuses = (Button) findViewById(R.id.addBuses);

        userFeedback = (TextView) findViewById(R.id.checkuserFeedback);
    }

    private void methodListner() {
        addTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin.this, Add_Data_Train.class );
                startActivity(i);
            }
        });

        addFlights.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin.this, AddFlightData.class);
                startActivity(i);
            }
        });

        addBuses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin.this, AddBusData.class);
                startActivity(i);
            }
        });
        userFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin.this, UserFeedback.class);
                startActivity(i);

            }
        });
    }


}
