package com.grv.vikash.smartrip.ForAdmin;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.Calendar;

public class Add_Data_Train extends AppCompatActivity {

    String selectedTimeByUser;

    EditText  train_No,train_Name, from, to, totalTime, totalKms;
    TextView startTime;
    Button add, show, addMidStationBtn;
    CheckBox sun, mon, tue, wed, thu, fri, sat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data__train);

        init();
        methodListner();


        getSupportActionBar().setTitle("Add Train details");
    }

    private void init() {
        train_No = (EditText) findViewById(R.id.addTrainNo);
        train_Name = (EditText) findViewById(R.id.addTrainName);
        from = (EditText) findViewById(R.id.addTrainFrom);
        to = (EditText) findViewById(R.id.addTrainTo);
        totalTime = (EditText) findViewById(R.id.addTotalTrainTime);
        totalKms = (EditText) findViewById(R.id.addTotalKms);

        startTime = (TextView) findViewById(R.id.addStartTrainTime);


        add = (Button) findViewById(R.id.addTrainBtn);
        show = (Button) findViewById(R.id.addShowTrainListBtn);
        addMidStationBtn = (Button) findViewById(R.id.addMidStationBtn);

        sun = (CheckBox) findViewById(R.id.addDays_Sun);
        mon = (CheckBox) findViewById(R.id.addDays_Mon);
        tue = (CheckBox) findViewById(R.id.addDays_Tue);
        wed = (CheckBox) findViewById(R.id.addDays_Wed);
        thu = (CheckBox) findViewById(R.id.addDays_Thu);
        fri = (CheckBox) findViewById(R.id.addDays_Fri);
        sat = (CheckBox) findViewById(R.id.addDays_Sat);
    }

    private void methodListner() {


        //Add Train Start Time
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTrainTime();
            }
        });

        //Add DATA  on Train
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTrainData();
            }
        });

        //Show Train List
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(Add_Data_Train.this, Train_List.class);
                startActivity(i);
                finish();
            }
        });

        addMidStationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Add_Data_Train.this, train_mid_stations.class);
                startActivity(i);
            }
        });
    }


    private void startTrainTime() {

        Calendar calendar = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selectedTimeByUser = "" + hour + ":" + minute;
                startTime.setText(selectedTimeByUser);
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), false);
        dialog.show();
    }



    private void addTrainData() {

        String sunday = "", monday = "", tuesday = "",wednesday = "",thrusday = "",friday = "",saturday = "";

        String enteredNo = train_No.getText().toString();
        String enteredName = train_Name.getText().toString();
        String enteredfrom = from.getText().toString();
        String enteredto = to.getText().toString();
        String enteredstartTime = startTime.getText().toString();
        String enteredTotalTime = totalTime.getText().toString();
        String enteredTotalKms = totalKms.getText().toString();

        if(enteredNo.equals("") || enteredName.equals("") || enteredfrom.equals("") || enteredto.equals("")
                || enteredTotalTime.equals("") || enteredstartTime.equals("") || enteredTotalKms.equals("")){
            Toast.makeText(this, "fill all the fields", Toast.LENGTH_SHORT).show();
        }

        else{
            Log.d("check", "addTrainData: else !");
           if(sun.isChecked()) {
                sunday = sun.getText().toString();
            }
            if(mon.isChecked()) {
                monday = mon.getText().toString();
            }
            if(tue.isChecked()) {
                tuesday = tue.getText().toString();
            }
            if (wed.isChecked()) {
                wednesday = wed.getText().toString();
            }
            if (thu.isChecked()) {
                thrusday = thu.getText().toString();
            }
            if(fri.isChecked()){
                friday = fri.getText().toString();
            }
            if (sat.isChecked()) {
                saturday = sat.getText().toString();
            }



            if(!sun.isChecked()) {
                sunday=null;
            }
            if(!mon.isChecked()) {
                monday=null;
            }
            if(!tue.isChecked()) {
                tuesday = null;
            }
            if (!wed.isChecked()) {
                wednesday=null;
            }
            if (!thu.isChecked()) {
                thrusday=null;
            }
            if(!fri.isChecked()){
                friday=null;
            }
            if (!sat.isChecked()) {
                saturday=null;
            }



            MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
            SQLiteDatabase db =  sql.getWritableDatabase();

            ContentValues cv = new ContentValues();

            cv.put(AddTrain_Table.NO, enteredNo);
            cv.put(AddTrain_Table.NAME, enteredName);
            cv.put(AddTrain_Table.DESTINATION, enteredto);
            cv.put(AddTrain_Table.SOURCE, enteredfrom);
            cv.put(AddTrain_Table.START_TIME, enteredstartTime);
            cv.put(AddTrain_Table.TOTAL_TIME, enteredTotalTime);
            cv.put(AddTrain_Table.TOTAL_kMS, enteredTotalKms);
            cv.put(AddTrain_Table.SUN, sunday);
            cv.put(AddTrain_Table.MON, monday);
            cv.put(AddTrain_Table.TUE, tuesday);
            cv.put(AddTrain_Table.WED, wednesday);
            cv.put(AddTrain_Table.THU, thrusday);
            cv.put(AddTrain_Table.FRI, friday);
            cv.put(AddTrain_Table.SAT, saturday);


            if(AddTrain_Table.insert(db, cv) > 0){
                train_No.setText("");
                train_Name.setText("");
                from.setText("");
                to.setText("");
                startTime.setText("");
                totalTime.setText("");
                totalKms.setText("");
                sun.setChecked(false);
                mon.setChecked(false);
                tue.setChecked(false);
                wed.setChecked(false);
                thu.setChecked(false);
                fri.setChecked(false);
                sat.setChecked(false);

                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Train No already Exist", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
    }

}

