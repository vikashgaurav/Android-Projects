package com.grv.vikash.smartrip.Activity_Train;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.ForAdmin.MidStationList;
import com.grv.vikash.smartrip.MyArrayAdapter.UserTrainListAdapter;
import com.grv.vikash.smartrip.MyPojo.userTrainListPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;

public class Train_By_No extends AppCompatActivity {

    EditText trainByNo;
    Button searchByNoBtn;
    ListView lv;


    ArrayList<userTrainListPojo> userTrainArray = new ArrayList<>();
    UserTrainListAdapter userTrainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train__by__no);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Train By Number");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();
        methodlistner();

        userTrainAdapter = new UserTrainListAdapter(this, R.layout.user_trainlistdesign, userTrainArray);
        lv.setAdapter(userTrainAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {

        trainByNo = (EditText) findViewById(R.id.userSearchTrainByNo);
        searchByNoBtn = (Button) findViewById(R.id.usertrainbynobtn);

        lv = (ListView) findViewById(R.id.userTarinByNoLV);
    }

    private void methodlistner() {

        searchByNoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredNo = trainByNo.getText().toString();

                if (enteredNo.equals("")) {
                    Toast.makeText(Train_By_No.this, "Entere train no", Toast.LENGTH_SHORT).show();
                } else {
                    MySQLiteOpenHelper sql = new MySQLiteOpenHelper(Train_By_No.this);
                    SQLiteDatabase db = sql.getReadableDatabase();

                    String sel = AddTrain_Table.NO + "= '" + enteredNo + "'";

                    Cursor cursor = AddTrain_Table.select(db, sel);

                    if (cursor != null) {
                        while (cursor.moveToNext()) {

                            String userTno = cursor.getString(0);
                            addUserTrainList(userTno);
                        }
                    }
                    cursor.close();
                    db.close();
                }
            }
        });



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userTrainListPojo pojo = userTrainArray.get(i);

                Intent intent = new Intent(Train_By_No.this, MidStationList.class);
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

        if (cursor != null) {
            if (cursor.getCount() == 0) {
                Toast.makeText(Train_By_No.this, "Not Matched", Toast.LENGTH_SHORT).show();
            }
            while (cursor.moveToNext()) {

                String trainNo = cursor.getString(0);
                String name = cursor.getString(1);
                String source = cursor.getString(2);
                String destination = cursor.getString(3);
                String start = cursor.getString(4);
                String fare = cursor.getString(6);
                String sun = cursor.getString(7);
                String mon = cursor.getString(8);
                String tue = cursor.getString(9);
                String wed = cursor.getString(10);
                String thu = cursor.getString(11);
                String fri = cursor.getString(12);
                String sat = cursor.getString(13);

                Log.d("q", "addUserTrainList: " + name);

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
                pojo.setUserTrainSource(source);
                pojo.setUserTrainDestiantion(destination);
                pojo.setUserTrainfare(fare);
                pojo.setUserTrainStartTime(start);
                pojo.setUserTrainendTime("2:00");

                Log.d("q", "addUserTrainList: " + pojo);

                userTrainArray.add(pojo);
            }
            userTrainAdapter.notifyDataSetChanged();
        }

    }
}
