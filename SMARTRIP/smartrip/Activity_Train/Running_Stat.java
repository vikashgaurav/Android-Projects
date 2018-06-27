package com.grv.vikash.smartrip.Activity_Train;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.grv.vikash.smartrip.R;

import java.util.Calendar;

public class Running_Stat extends AppCompatActivity {

    TextView date;
    Button get_Status;
    String selectDateByUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running__stat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Running Status");

        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        init();
        methodListner();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void init() {

        date = (TextView) findViewById(R.id.dateRunStaus);
        get_Status =(Button) findViewById(R.id.get_status);
    }


    private void methodListner() {

        date.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Running_Stat.this, new DatePickerDialog.OnDateSetListener(){

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
}


