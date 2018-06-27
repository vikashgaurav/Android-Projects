package com.grv.vikash.smartrip.ForAdmin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.AddTrainAdapter;
import com.grv.vikash.smartrip.MyPojo.Add_TrainPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;

public class Train_List extends AppCompatActivity {

    ListView lv;
    AddTrainAdapter addtrain;

    public static String no;

    ArrayList<Add_TrainPojo> arrayTrainList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train__list);

        init();

        addtrain = new AddTrainAdapter(this, R.layout.train_list_design, arrayTrainList);
        lv.setAdapter(addtrain);

        fetchData();
        methodlistner();
        getSupportActionBar().setTitle("Train List");
    }

    private void init() {

        lv = (ListView) findViewById(R.id.listViewTrains);
    }

    private void methodlistner() {
    }

    private void fetchData() {
        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        Cursor cursor = AddTrain_Table.select(db, null);

        if(cursor!= null){
            while(cursor.moveToNext()){
                no = cursor.getString(0);
                String name = cursor.getString(1);
                String source = cursor.getString(2);
                String destination = cursor.getString(3);
                String startTime = cursor.getString(4);
                String totalTime = cursor.getString(5);
                String totalKms = cursor.getString(6);
                String sun = cursor.getString(7);
                String mon = cursor.getString(8);
                String tue = cursor.getString(9);
                String wed =  cursor.getString(10);
                String thu = cursor.getString(11);
                String fri = cursor.getString(12);
                String sat = cursor.getString(13);

                Add_TrainPojo pojo = new Add_TrainPojo();

                pojo.setNo(no);
                pojo.setName(name);
                pojo.setSource(source);
                pojo.setDestination(destination);
                pojo.setStart(startTime);
                pojo.setTotalTime(totalTime);
                pojo.setTotalkms(totalKms);
                pojo.setSun(sun);
                pojo.setMon(mon);
                pojo.setTue(tue);
                pojo.setWed(wed);
                pojo.setThu(thu);
                pojo.setFri(fri);
                pojo.setSat(sat);

                arrayTrainList.add(pojo);
            }
            addtrain.notifyDataSetChanged();
            cursor.close();
            db.close();
        }

    }
}
