package com.grv.vikash.smartrip.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.grv.vikash.smartrip.Activity_Buses.UserBusList;
import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddBusAdapter;
import com.grv.vikash.smartrip.MyPojo.AddBusPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddBusTable;

import java.util.ArrayList;
import java.util.Calendar;

public class Buses extends AppCompatActivity {
    TableLayout trains, flights, you;
    TextView date;
    String selectDateByUser;
    EditText source, destination;
    Button searchBus;

    ArrayList<AddBusPojo> userBusArray = new ArrayList<>();
    AddBusAdapter userBusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses);

        init();
        methodlistner();
    }

    private void init() {

        trains = (TableLayout) findViewById(R.id.trains);
        flights = (TableLayout) findViewById(R.id.flights);
        you = (TableLayout) findViewById(R.id.you);

        date = (TextView) findViewById(R.id.datepicker);

        searchBus = (Button) findViewById(R.id.searchBusBtn);

        source = (EditText) findViewById(R.id.busSourceET);
        destination = (EditText) findViewById(R.id.busDestinationET);
    }

    private void methodlistner() {
        trains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Buses.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        flights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Buses.this, Flight.class);
                startActivity(i);
                finish();
            }
        });
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Buses.this, You.class);
                startActivity(i);
                finish();
            }
        });

        searchBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBuses();
            }
        });



        date.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Buses.this, new DatePickerDialog.OnDateSetListener(){

                    @Override
                   public void onDateSet(DatePicker view, int year, int month, int day) {
                        selectDateByUser = "" +day +" - "+month+" - "+year;
                        date.setText(selectDateByUser);
                    }

                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) );
                datePickerDialog.show();
            }
        });
    }

    private void showBuses() {

        String enteredSource = source.getText().toString();
        String enteredDestination = destination.getText().toString();

        if(enteredSource.equals("") || enteredDestination.equals("")){
            Toast.makeText(this, "Entere all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            MySQLiteOpenHelper sql =  new MySQLiteOpenHelper(Buses.this);
            SQLiteDatabase  db = sql.getReadableDatabase();

            String selction = AddBusTable.BUS_SOURCE + "= '" + enteredSource + "' AND " + AddBusTable.BUS_DESTINATION+ " = '"
                    + enteredDestination + "'";

            Cursor cursor = AddBusTable.select(db, selction);
            if(cursor!=null){
                while (cursor.moveToNext()){
                    Toast.makeText(this, "Matches", Toast.LENGTH_SHORT).show();
                    String Busid = cursor.getString(0);
                    Log.d("q", "showBuses: "+Busid);

                    Intent i = new Intent(Buses.this, UserBusList.class);
                    i.putExtra("bus_id", Busid);
                    startActivity(i);
                }
                if (cursor.getCount() == 0)
                {
                    Toast.makeText(Buses.this, "Not Matched", Toast.LENGTH_SHORT).show();
                    userBusArray.clear();
                }
            }
        }
    }
}
