package com.grv.vikash.smartrip.ForAdmin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddBusAdapter;
import com.grv.vikash.smartrip.MyPojo.AddBusPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddBusTable;

import java.util.ArrayList;

public class BusList extends AppCompatActivity {

    ListView lv;

    ArrayList<AddBusPojo> busArray = new ArrayList<>();
    AddBusAdapter busAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_list);

        init();

        busAdapter = new AddBusAdapter(this, R.layout.buslistdesign, busArray);
        lv.setAdapter(busAdapter);

        fetchData();
    }

    private void init() {
        lv = (ListView) findViewById(R.id.BusListView);
    }

    private void fetchData() {
        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        Cursor cursor = AddBusTable.select(db, null);

        if(cursor != null){
            while (cursor.moveToNext()){

                int id = cursor.getInt(0);
                String agency = cursor.getString(1);
                String busType = cursor.getString(2);
                String busSource = cursor.getString(3);
                String busDestination = cursor.getString(4);
                String busStartTime = cursor.getString(5);
                String busEndTime = cursor.getString(6);
                String busTotal = cursor.getString(7);
                String busSeat = cursor.getString(8);
                String busFare = cursor.getString(9);

                AddBusPojo pojo = new AddBusPojo();

                pojo.setId(id);
                pojo.setBusAgency(agency);
                pojo.setBusType(busType);
                pojo.setBusSource(busSource);
                pojo.setBusDestination(busDestination);
                pojo.setBusStartTime(busStartTime);
                pojo.setBusEndTime(busEndTime);
                pojo.setTotalBusTime(busTotal);
                pojo.setBusSeat(busSeat);
                pojo.setBusFare(busFare);

                busArray.add(pojo);
            }
            busAdapter.notifyDataSetChanged();
            cursor.close();
            db.close();
        }
    }
}
