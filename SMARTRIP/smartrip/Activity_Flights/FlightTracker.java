package com.grv.vikash.smartrip.Activity_Flights;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddFlightAdapter;
import com.grv.vikash.smartrip.MyPojo.Add_Flight_Pojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddFlightTable;

import java.util.ArrayList;

public class FlightTracker extends AppCompatActivity {

    EditText flightNo;
    Button trackbtn;
    ListView flv;

    ArrayList<Add_Flight_Pojo> flightArray = new ArrayList<>();
    AddFlightAdapter flightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_tracker);

        getSupportActionBar().setTitle("Track your Flight");

        init();
        methdListner();

        flightAdapter = new AddFlightAdapter(this, R.layout.user_flightlstdesign, flightArray);
        flv.setAdapter(flightAdapter);
    }

    private void init() {

        flv = (ListView) findViewById(R.id.userFlighttrckerlistView);
        flightNo = (EditText) findViewById(R.id.userSearchFlightByNo);
        trackbtn = (Button) findViewById(R.id.userFlightbyNobtn);
    }

    private void methdListner() {

        trackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
            }
        });
    }

    private void fetchdata() {

        String  enteredno = flightNo.getText().toString();

        if(enteredno.equals("")){
            Toast.makeText(this, "Entere flight no", Toast.LENGTH_SHORT).show();
        }
        else{
            flightArray.clear();

            MySQLiteOpenHelper sql = new MySQLiteOpenHelper(FlightTracker.this);
            SQLiteDatabase db = sql.getReadableDatabase();

            String selction = AddFlightTable.FNO + "= '" + enteredno+ "'";

            Cursor cursor = AddFlightTable.select(db, selction);

            if(cursor!=null){
                if (cursor.getCount() == 0)
                {
                    Toast.makeText(FlightTracker.this, "Not Matched", Toast.LENGTH_SHORT).show();
                }
                while (cursor.moveToNext()){
                    int ID = cursor.getInt(0);
                    String flight = cursor.getString(1);
                    String no = cursor.getString(2);
                    String source = cursor.getString(3);
                    String destination = cursor.getString(4);
                    String startTime = cursor.getString(5);
                    String endTime = cursor.getString(6);
                    String sun = cursor.getString(7);
                    String mon = cursor.getString(8);
                    String tue = cursor.getString(9);
                    String wed =  cursor.getString(10);
                    String thu = cursor.getString(11);
                    String fri = cursor.getString(12);
                    String sat = cursor.getString(13);
                    String fare = cursor.getString(14);

                    Add_Flight_Pojo pojo = new Add_Flight_Pojo();

                    pojo.setId(ID);
                    pojo.setFlight(flight);
                    pojo.setNo(no);
                    pojo.setSource(source);
                    pojo.setDestination(destination);
                    pojo.setStartTime(startTime);
                    pojo.setEndTime(endTime);
                    pojo.setSun(sun);
                    pojo.setMon(mon);
                    pojo.setTue(tue);
                    pojo.setWed(wed);
                    pojo.setThu(thu);
                    pojo.setFri(fri);
                    pojo.setSat(sat);
                    pojo.setFare(fare);

                    flightArray.add(pojo);

                }
                flightAdapter.notifyDataSetChanged();
                db.close();
                cursor.close();
            }
        }
    }

}
