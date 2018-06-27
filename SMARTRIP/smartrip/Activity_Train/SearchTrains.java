package com.grv.vikash.smartrip.Activity_Train;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.ForAdmin.MidStationList;
import com.grv.vikash.smartrip.MyArrayAdapter.UserTrainListAdapter;
import com.grv.vikash.smartrip.MyPojo.Add_TrainPojo;
import com.grv.vikash.smartrip.MyPojo.userTrainListPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddMidStationTAble;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;
import java.util.Calendar;

public class SearchTrains extends AppCompatActivity {

    TextView date;
    Button search;
    String selectDateByUser;
    AutoCompleteTextView fromTrain, toTrain;
    ListView lv;

    String enteredFrom, enteredTo;

    ArrayList<userTrainListPojo> userTrainArray = new ArrayList<>();
    UserTrainListAdapter userTrainAdapter;

    //For AutoComplte TExtView
    ArrayList<String> midStationArray = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trains);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        methodListner();

        //For AutoComplte TExtView
        arrayAdapter = new ArrayAdapter(this, R.layout.spinner_list, midStationArray);
        fromTrain.setAdapter(arrayAdapter);
       // toTrain.setAdapter(arrayAdapter);

        addMidStationToAutoText();

        userTrainAdapter = new UserTrainListAdapter(this, R.layout.user_trainlistdesign, userTrainArray);
        lv.setAdapter(userTrainAdapter);

        getSupportActionBar().setTitle("Search Trains");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {
        date = (TextView) findViewById(R.id.datepickerTrain);

        search = (Button) findViewById(R.id.searchBtnTrain);

        fromTrain = (AutoCompleteTextView) findViewById(R.id.fromTrain);
        toTrain = (AutoCompleteTextView) findViewById(R.id.toTrain);

        lv = (ListView) findViewById(R.id.listViewSearchTrain);
    }


    //For AutoComplte TExtView
    private void addMidStationToAutoText() {

        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        String selection = AddMidStationTAble.MID_STATION;

        Cursor cursor = db.query(AddMidStationTAble.MID_TABLE_NAME, null, selection, null, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                String midName = cursor.getString(2);
                midStationArray.add(midName);
                Log.d("qwe", "addMidStationToAutoText: "+midName);
            }
            arrayAdapter.notifyDataSetChanged();
        }
    }


    private void methodListner() {

        date.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchTrains.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        selectDateByUser = "" + day + " - " + month + " - " + year;
                        date.setText(selectDateByUser);
                    }

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchTrain();
            }

            private void searchTrain() {
                enteredFrom = fromTrain.getText().toString();
                enteredTo = toTrain.getText().toString();

                if (enteredFrom.equals("") || enteredTo.equals("")) {
                    Toast.makeText(SearchTrains.this, "Enter Details", Toast.LENGTH_SHORT).show();
                } else {
                    MySQLiteOpenHelper sql = new MySQLiteOpenHelper(SearchTrains.this);
                    SQLiteDatabase db = sql.getReadableDatabase();

                    String sel = "SELECT " + AddMidStationTAble.TRAIN_NO + " FROM " + AddMidStationTAble.MID_TABLE_NAME + " WHERE "
                            + AddMidStationTAble.MID_STATION + " IN('" + enteredFrom + "','" + enteredTo + "')" + "GROUP BY "
                            + AddMidStationTAble.TRAIN_NO + " HAVING COUNT(DISTINCT mid_station)=2";

                    Cursor cursor = db.rawQuery(sel, null);

                    if (cursor != null) {

                        if (cursor.getCount() == 0) {
                            Toast.makeText(SearchTrains.this, "Not Matched", Toast.LENGTH_SHORT).show();
                        }
                        while (cursor.moveToNext()) {
                            Toast.makeText(SearchTrains.this, "Matches", Toast.LENGTH_SHORT).show();

                            String userTno = cursor.getString(0);
                            addUserTrainList(userTno);
                            Log.d("q", "searchTrain: "+userTno);
                        }

                        cursor.close();
                        db.close();
                    }
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userTrainListPojo pojo = userTrainArray.get(i);

                Intent intent = new Intent(SearchTrains.this, MidStationList.class);
                intent.putExtra("train_id", pojo.getUserTrainno());
                startActivity(intent);
            }
        });
    }

    private void addUserTrainList(String userTno) {

        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        String selction = AddTrain_Table.NO + " = '" + userTno + "'";

        Cursor cursor = db.query(AddTrain_Table.TRAIN_TABLE_NAME, null, selction, null, null, null, null, null);

        if (cursor!=null) {
            while (cursor.moveToNext()) {

                String trainNo = cursor.getString(0);
                String name = cursor.getString(1);
                String sun = cursor.getString(7);
                String mon = cursor.getString(8);
                String tue = cursor.getString(9);
                String wed = cursor.getString(10);
                String thu = cursor.getString(11);
                String fri = cursor.getString(12);
                String sat = cursor.getString(13);

                userTrainListPojo pojo = new userTrainListPojo();

                pojo.setUserTrainno(trainNo);
                pojo.setUserTrainName(name);
                pojo.setS(sun);
                pojo.setM(mon);
                pojo.setT(tue);
                pojo.setW(wed);
                pojo.setTh(thu);
                pojo.setF(fri);
                pojo.setSa(sat);
                pojo.setUserTrainSource(enteredFrom);
                pojo.setUserTrainDestiantion(enteredTo);
                pojo.setUserTrainfare("120");
                pojo.setUserTrainStartTime("12:00");
                pojo.setUserTrainendTime("2:00");

                userTrainArray.add(pojo);
            }
            userTrainAdapter.notifyDataSetChanged();
        }
    }
}
