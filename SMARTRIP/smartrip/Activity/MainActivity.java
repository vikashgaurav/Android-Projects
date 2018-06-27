package com.grv.vikash.smartrip.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.grv.vikash.smartrip.Activity_Train.Offline_Routes;
import com.grv.vikash.smartrip.Activity_Train.PNRStatus;
import com.grv.vikash.smartrip.Activity_Train.PNR_Stat;
import com.grv.vikash.smartrip.Activity_Train.RunningTrain;
import com.grv.vikash.smartrip.Activity_Train.Running_Stat;
import com.grv.vikash.smartrip.Activity_Train.SearchTrains;
import com.grv.vikash.smartrip.Activity_Train.SeatCalender;
import com.grv.vikash.smartrip.Activity_Train.Seat_Calender;
import com.grv.vikash.smartrip.Activity_Train.Seat_Map;
import com.grv.vikash.smartrip.Activity_Train.TrainBooking;
import com.grv.vikash.smartrip.Activity_Train.Train_By_No;
import com.grv.vikash.smartrip.R;

public class MainActivity extends AppCompatActivity {
    TableLayout flight, bus, you;
    RelativeLayout searchTrain, PNR, runningTrain, seatCalender, trainByNo, offlineRoutes,
            seatTrainMap, BookTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        methodlistner();
    }



    private void init() {

        flight = (TableLayout) findViewById(R.id.flights);
        bus =  (TableLayout) findViewById(R.id.bus);
        you = (TableLayout) findViewById(R.id.you);

        // find id of Options
        searchTrain = (RelativeLayout) findViewById(R.id.searchtrain);
        PNR = (RelativeLayout) findViewById(R.id.PNR);
        runningTrain = (RelativeLayout) findViewById(R.id.runningTrain);
        seatCalender = (RelativeLayout) findViewById(R.id.seatCalender);
        trainByNo = (RelativeLayout) findViewById(R.id.trainByNo);
        offlineRoutes = (RelativeLayout) findViewById(R.id.offlineRoute);
        seatTrainMap = (RelativeLayout) findViewById(R.id.seatMap);
        BookTrain = (RelativeLayout) findViewById(R.id.myBookingTrain);
    }


    private void methodlistner() {
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Flight.class);
                startActivity(i);
                finish();
            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Buses.class);
                startActivity(i);
                finish();
            }
        });
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, You.class);
                startActivity(i);
                finish();
            }
        });

        searchTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SearchTrains.class);
                startActivity(i);
            }
        });

        PNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, PNRStatus.class);
                startActivity(i);
            }
        });

        seatCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SeatCalender.class);
                startActivity(i);
            }
        });

        trainByNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Train_By_No.class);
                startActivity(i);
            }
        });

        offlineRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Offline_Routes.class);
                startActivity(i);
            }
        });

        seatTrainMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Seat_Map.class);
                startActivity(i);
            }
        });

        BookTrain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TrainBooking.class);
                startActivity(i);
            }
        });

        runningTrain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RunningTrain.class);
                startActivity(i);
            }
        });
    }
}
