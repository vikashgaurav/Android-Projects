package com.grv.vikash.smartrip.Activity_Flights;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.grv.vikash.smartrip.Activity_Train.SearchTrains;
import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddFlightAdapter;
import com.grv.vikash.smartrip.MyPojo.Add_Flight_Pojo;
import com.grv.vikash.smartrip.MyPojo.userTrainListPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddFlightTable;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;
import java.util.Calendar;

public class Search_Flights extends AppCompatActivity {

    TextView date, Class;
    Button searchflights;
    String selectDateByUser;
    TextView classFlight;
    EditText sourceFlight, destinationFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__flights);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        methodListner();

        getSupportActionBar().setTitle("Search Flights");

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

        date = (TextView) findViewById(R.id.datepicSearchflights);
        Class = (TextView) findViewById(R.id.classFlight);
        classFlight =(TextView) findViewById(R.id.classFlight);

        searchflights = (Button) findViewById(R.id.searchBtnFlight);

        sourceFlight = (EditText) findViewById(R.id.searchSourceFlightET);
        destinationFlight = (EditText) findViewById(R.id.searchDestiantionFlightET);

    }
    private void methodListner() {


        date.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Search_Flights.this, new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        selectDateByUser = "" +day +" - "+month+" - "+year;
                        date.setText(selectDateByUser);
                    }

                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) );
                datePickerDialog.show();
            }
        });



        classFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final CharSequence Flightclass[] = new CharSequence[] {"Economy", "Bussiness", "Premium Economy"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Search_Flights.this);
                builder.setTitle("Select your class");
                builder.setItems(Flightclass, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // the user clicked on class[which]
                        String enteredClass = (String) Flightclass[which];
                        classFlight.setText(enteredClass);
                    }
                });
                builder.show();
            }
        });

        searchflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enteredSource = sourceFlight.getText().toString();
                String enteredDestination = destinationFlight.getText().toString();

                if (enteredSource.equals("") || enteredDestination.equals("")){
                    Toast.makeText(Search_Flights.this, "Entere all the field", Toast.LENGTH_SHORT).show();
                }
                else{
                    MySQLiteOpenHelper sql = new MySQLiteOpenHelper(Search_Flights.this);
                    SQLiteDatabase db = sql.getReadableDatabase();

                    String selction = AddFlightTable.FSOURCE + "= '" + enteredSource + "' AND " + AddFlightTable.FDESTINATION+ " = '"
                            + enteredDestination + "'";

                    Cursor cursor = AddFlightTable.select(db, selction);

                    if(cursor!=null){
                        if (cursor.getCount() == 0)
                        {
                            Toast.makeText(Search_Flights.this, "Not Matched", Toast.LENGTH_SHORT).show();
                        }
                        while (cursor.moveToNext()){
                            Toast.makeText(Search_Flights.this, "Matches", Toast.LENGTH_SHORT).show();

                            int fid = cursor.getInt(0);

                            Intent i = new Intent(Search_Flights.this, userFlightList.class);
                            i.putExtra("f_id", fid);
                            startActivity(i);
                        }
                    }

                }
            }
        });
    }
}
