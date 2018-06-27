package com.grv.vikash.smartrip.ForAdmin;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddFlightTable;

public class AddFlightData extends AppCompatActivity {

    String selcetTimeByUser;

    TextView flight, fno, fsource, fdestination, fstartTime, fendTime, fare;
    Button fadd, fshowlist;
    CheckBox sun, mon, tue, wed, thu, fri, sat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight_data);

        init();
        methodlistner();
        getSupportActionBar().setTitle("Ac One");
    }


    private void init() {

        flight  = (TextView) findViewById(R.id.addFlightName);
        fno = (TextView) findViewById(R.id.addFlightNo);
        fsource = (TextView) findViewById(R.id.addFlightFrom);
        fdestination = (TextView) findViewById(R.id.addFlightTo);
        fstartTime = (TextView) findViewById(R.id.addStartFlightTime);
        fendTime = (TextView) findViewById(R.id.addEndFlightTime);
        fare  = (TextView) findViewById(R.id.addFlightFare);

        fadd = (Button) findViewById(R.id.addFlightBtn);
        fshowlist = (Button) findViewById(R.id.addShowFlightListBtn);

        sun =  (CheckBox) findViewById(R.id.addDaysFSun);
        mon = (CheckBox) findViewById(R.id.addDaysFMon);
        tue = (CheckBox) findViewById(R.id.addDaysFTue);
        wed = (CheckBox) findViewById(R.id.addDaysFWed);
        thu = (CheckBox) findViewById(R.id.addDaysFThu);
        fri = (CheckBox) findViewById(R.id.addDaysFFri);
        sat = (CheckBox) findViewById(R.id.addDaysFSat);

    }

    private void methodlistner() {
        fstartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sartTrainTime();
            }
        });


        fendTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTime();
            }
        });

        fadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addflightDAta();
            }
        });

        fshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddFlightData.this, Flight_List.class);
                startActivity(i);
            }
        });
    }


    private void endTime() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selcetTimeByUser = "" + hour + ":" + minute;
                fendTime.setText(selcetTimeByUser);
            }
        }, calendar.get(java.util.Calendar.HOUR), calendar.get(java.util.Calendar.MINUTE), false);
        dialog.show();
    }

    private void sartTrainTime() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selcetTimeByUser = "" + hour + ":" + minute;
                fstartTime.setText(selcetTimeByUser);
            }
        }, calendar.get(java.util.Calendar.HOUR), calendar.get(java.util.Calendar.MINUTE), false);
        dialog.show();
    }


    private void addflightDAta() {
        String fsunday = "", fmonday = "", ftuesday = "",fwednesday = "",fthrusday = "",ffriday = "",fsaturday = "";

        String enteredFname = flight.getText().toString();
        String enteredfno = fno.getText().toString();
        String enteredfsource = fsource.getText().toString();
        String enteredfdestination = fdestination.getText().toString();
        String enteredfstart = fstartTime.getText().toString();
        String enteredfend = fendTime.getText().toString();
        String enteredfare = fare.getText().toString();

        if(enteredFname.equals("") || enteredfno.equals("") || enteredfsource.equals("") || enteredfdestination.equals("")
                || enteredfstart.equals("") || enteredfend.equals("") || enteredfare.equals("")){
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            if(sun.isChecked()) {
                fsunday = sun.getText().toString();
            }
            if(mon.isChecked()) {
                fmonday = mon.getText().toString();
            }
            if(tue.isChecked()) {
                ftuesday = tue.getText().toString();
            }
            if (wed.isChecked()) {
                fwednesday = wed.getText().toString();
            }
            if (thu.isChecked()) {
                fthrusday = thu.getText().toString();
            }
            if(fri.isChecked()){
                ffriday = fri.getText().toString();
            }
            if (sat.isChecked()) {
                fsaturday = sat.getText().toString();
            }



            if(!sun.isChecked()) {
                fsunday=null;
            }
            if(!mon.isChecked()) {
               fmonday=null;
            }
            if(!tue.isChecked()) {
                ftuesday = null;
            }
            if (!wed.isChecked()) {
                fwednesday=null;
            }
            if (!thu.isChecked()) {
                fthrusday=null;
            }
            if(!fri.isChecked()){
                ffriday=null;
            }
            if (!sat.isChecked()) {
                fsaturday=null;
            }



            MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
            SQLiteDatabase db =  sql.getWritableDatabase();

            ContentValues cv = new ContentValues();

            cv.put(AddFlightTable.FNAME, enteredFname);
            cv.put(AddFlightTable.FNO, enteredfno);
            cv.put(AddFlightTable.FSOURCE, enteredfsource);
            cv.put(AddFlightTable.FDESTINATION, enteredfdestination);
            cv.put(AddFlightTable.FSTART_TIME, enteredfstart);
            cv.put(AddFlightTable.FEND_TIME, enteredfend);
            cv.put(AddFlightTable.FARE, enteredfare);
            cv.put(AddFlightTable.SUN, fsunday);
            cv.put(AddFlightTable.MON,fmonday);
            cv.put(AddFlightTable.TUE, ftuesday);
            cv.put(AddFlightTable.WED, fwednesday);
            cv.put(AddFlightTable.THU, fthrusday);
            cv.put(AddFlightTable.FRI, ffriday);
            cv.put(AddFlightTable.SAT, fsaturday);

            if(AddFlightTable.insert(db, cv) >0){
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                fno.setText("");
                flight.setText("");
                fsource.setText("");
                fdestination.setText("");
                fstartTime.setText("");
                fendTime.setText("");
                fare.setText("");
                sun.setChecked(false);
                mon.setChecked(false);
                tue.setChecked(false);
                wed.setChecked(false);
                thu.setChecked(false);
                fri.setChecked(false);
                sat.setChecked(false);
            }
            else{
                Toast.makeText(this, "Flight No Already Exist", Toast.LENGTH_SHORT).show();
            }
            db.close();

        }
    }
}
