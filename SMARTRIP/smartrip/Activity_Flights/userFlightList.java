package com.grv.vikash.smartrip.Activity_Flights;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddFlightAdapter;
import com.grv.vikash.smartrip.MyPojo.Add_Flight_Pojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddFlightTable;

import java.util.ArrayList;

public class userFlightList extends AppCompatActivity {

    ListView flv;

    ArrayList<Add_Flight_Pojo> flightArray = new ArrayList<>();
    AddFlightAdapter flightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_flight_list);

        getSupportActionBar().setTitle("Flight List");

        init();

        flightAdapter = new AddFlightAdapter(this, R.layout.user_flightlstdesign, flightArray);
        flv.setAdapter(flightAdapter);

        fetchdata(getIntent().getIntExtra("f_id", 0));
    }

    private void init() {
        flv = (ListView) findViewById(R.id.flightListView);
    }

    private void fetchdata(int f_id) {

        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        String selction = AddFlightTable.ID + " = '" + f_id + "'";

        Cursor cursor = db.query(AddFlightTable.Flight_TABLE_NAME, null, selction, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {

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
