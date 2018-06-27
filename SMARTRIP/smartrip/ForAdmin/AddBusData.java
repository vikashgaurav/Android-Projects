package com.grv.vikash.smartrip.ForAdmin;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.grv.vikash.smartrip.Activity.Buses;
import com.grv.vikash.smartrip.Activity_Flights.Search_Flights;
import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddBusTable;

public class AddBusData extends AppCompatActivity {

    EditText agencyName, source, destination, busFare, busSeatAvailable, busTotalTime;
    TextView busType, busStartTime, busEndTime;
    Button addBusBtn, showBusListBtn;

    String selcetTimeByUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bus_data);

        init();
        methodListner();
    }

    private void init() {
        agencyName = (EditText) findViewById(R.id.addAgencyName);
        source = (EditText) findViewById(R.id.addBusFrom);
        destination = (EditText) findViewById(R.id.addBusTo);
        busFare = (EditText) findViewById(R.id.addBusFare);
        busSeatAvailable = (EditText) findViewById(R.id.addBusSeatAvailabe);
        busTotalTime = (EditText) findViewById(R.id.addBusTotalTime);

        busType = (TextView) findViewById(R.id.addBusType);
        busStartTime = (TextView) findViewById(R.id.addStartBustTime);
        busEndTime = (TextView) findViewById(R.id.addEndBusTime);

        addBusBtn = (Button) findViewById(R.id.addBusBtn);
        showBusListBtn =  (Button) findViewById(R.id.addShowBusListBtn);
    }

    private void methodListner() {
        busStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBusTime();
            }
        });

        busEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endBusTime();
            }
        });

        busType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busTypeDetails();
            }
        });

        addBusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBusData();
            }
        });

        showBusListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddBusData.this, BusList.class);
                startActivity(i);
            }
        });
    }

    private void startBusTime() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selcetTimeByUser = "" + hour + ":" + minute;
                busStartTime.setText(selcetTimeByUser);
            }
        }, calendar.get(java.util.Calendar.HOUR), calendar.get(java.util.Calendar.MINUTE), false);
        dialog.show();
    }

    private void endBusTime() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selcetTimeByUser = "" + hour + ":" + minute;
                busEndTime.setText(selcetTimeByUser);
            }
        }, calendar.get(java.util.Calendar.HOUR), calendar.get(java.util.Calendar.MINUTE), false);
        dialog.show();
    }

    private void busTypeDetails() {

        final CharSequence Flightclass[] = new CharSequence[] {"Non A/C Seater/Sleeper", "A/C Seater/Sleeper"};

        AlertDialog.Builder builder = new AlertDialog.Builder(AddBusData.this);
        builder.setTitle("Select your class");
        builder.setItems(Flightclass, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on class[which]
                String enteredClass = (String) Flightclass[which];
                busType.setText(enteredClass);
            }
        });
        builder.show();
    }

    private void addBusData() {

        String enteredAgency = agencyName.getText().toString();
        String enteredBusTyppe = busType.getText().toString();
        String enterdBusSource = source.getText().toString();
        String enterdBusDestination = destination.getText().toString();
        String enterdBusStartTime = busStartTime.getText().toString();
        String enterdBusEndTime = busEndTime.getText().toString();
        String enterdBusTotalTime = busTotalTime.getText().toString();
        String enterdBusseat = busSeatAvailable.getText().toString();
        String enterdBusfare = busFare.getText().toString();

        if(enteredAgency.equals("") || enteredBusTyppe.equals("") || enterdBusSource.equals("") || enterdBusDestination.equals("")
                || enterdBusStartTime.equals("") || enterdBusEndTime.equals("") || enterdBusTotalTime.equals("")
                || enterdBusseat.equals("") || enterdBusfare.equals(""))
        {
            Toast.makeText(this, "Enter all the data", Toast.LENGTH_SHORT).show();
        }
        else{
            MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
            SQLiteDatabase db = sql.getWritableDatabase();

            ContentValues cv = new ContentValues();

            cv.put(AddBusTable.BUSAGENCTY, enteredAgency);
            cv.put(AddBusTable.BUSTYPE, enteredBusTyppe);
            cv.put(AddBusTable.BUS_SOURCE, enterdBusSource);
            cv.put(AddBusTable.BUS_DESTINATION, enterdBusDestination);
            cv.put(AddBusTable.BUS_STARTTIME, enterdBusStartTime);
            cv.put(AddBusTable.BUS_ENDTIME, enterdBusEndTime);
            cv.put(AddBusTable.BUS_TOTALTIME, enterdBusTotalTime);
            cv.put(AddBusTable.BUS_SEAT, enterdBusseat);
            cv.put(AddBusTable.BUS_FARE, enterdBusfare);

            if(AddBusTable.insert(db, cv) > 0){
                Toast.makeText(this, "Bus Data Entered", Toast.LENGTH_SHORT).show();
                agencyName.setText("");
                busType.setText("");
                source.setText("");
                destination.setText("");
                busTotalTime.setText("");
                busStartTime.setText("");
                busEndTime.setText("");
                busSeatAvailable.setText("");
                busFare.setText("");
            }
            else{
                Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
    }
}
