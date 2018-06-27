package com.grv.vikash.smartrip.ForAdmin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddMidStationTAble;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;

public class train_mid_stations extends AppCompatActivity {

    Spinner trainsSpinner;
    EditText midStation, totalTime, totalKms;
    Button addMid, showMidStation;

    String midStations;

    ArrayList<String> midTrainsArray = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_mid_stations);

        init();
        methodListner();
        fetchData();

        arrayAdapter = new ArrayAdapter(this, R.layout.spinner_list, midTrainsArray);
        trainsSpinner.setAdapter(arrayAdapter);

        getSupportActionBar().setTitle("Add mid Stations");
    }

    private void fetchData() {
        MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();

        String selection = AddTrain_Table.NO;

        Cursor cursor = sqLiteDatabase.query(AddTrain_Table.TRAIN_TABLE_NAME,null,selection,null,null,null,null,null);
        if(cursor!=null) {
            while (cursor.moveToNext()){
                String tno = cursor.getString(0);
                midTrainsArray.add(tno);
            }
        }
    }



    private  void init() {
         trainsSpinner = (Spinner) findViewById(R.id.trainsSpinner);

        midStation = (EditText) findViewById(R.id.midstationET);
        totalTime = (EditText) findViewById(R.id.totalTimeET);
        totalKms = (EditText) findViewById(R.id.totalKmsET);


        addMid = (Button) findViewById(R.id.addmidBTn);
        showMidStation = (Button) findViewById(R.id.showMidStnBTn);
    }


    private void methodListner() {

        addMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMidStation();
            }
        });

        trainsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 midStations = midTrainsArray.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        showMidStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(train_mid_stations.this, MidStationList.class);
                startActivity(i);
            }
        });
    }

    private void addMidStation() {
        String enteredMidStation = midStation.getText().toString();
        String enteredTotalTime = totalTime.getText().toString();
        String enteredTotalKms = totalKms.getText().toString();

        if(enteredMidStation.equals("") || enteredTotalTime.equals("") || enteredTotalKms.equals("")){
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        }else{

            MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
            SQLiteDatabase db = sql.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put(AddMidStationTAble.TRAIN_NO, midStations);
            cv.put(AddMidStationTAble.MID_STATION, enteredMidStation);
            cv.put(AddMidStationTAble.TOTAL_TIME, enteredTotalTime);
            cv.put(AddMidStationTAble.TOTAL_DISTANCE, enteredTotalKms);

            if(AddMidStationTAble.insert(db, cv) > 0){
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();

                midStation.setText("");
                totalTime.setText("");
                totalKms.setText("");
            }
            else{
                Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
