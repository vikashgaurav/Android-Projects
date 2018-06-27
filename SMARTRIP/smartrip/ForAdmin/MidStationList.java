package com.grv.vikash.smartrip.ForAdmin;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.MyArrayAdapter.MIdStationAdapter;
import com.grv.vikash.smartrip.MyPojo.MidStationPojo;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.AddMidStationTAble;
import com.grv.vikash.smartrip.Table.AddTrain_Table;

import java.util.ArrayList;

public class MidStationList extends AppCompatActivity {

    ListView mslv;

    MIdStationAdapter msAdapter;
    ArrayList<MidStationPojo> msArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_station_list);

        init();
        methodlistner();
        msAdapter = new MIdStationAdapter(this, R.layout.midstation_list_design, msArray);
        mslv.setAdapter(msAdapter);

        fetchDataMS(getIntent().getStringExtra("train_id"));
        getSupportActionBar().setTitle("Mid Station List");
    }

    private void methodlistner() {
        mslv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MidStationPojo rowID = msArray.get(i);
                listClick(rowID, i);
            }
        });
    }

    private void init() {
        mslv = (ListView) findViewById(R.id.midStationListView);
    }

    private void fetchDataMS(String train_id) {
        MySQLiteOpenHelper sql = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = sql.getReadableDatabase();

        Cursor cursor = AddMidStationTAble.select(db, AddMidStationTAble.TRAIN_NO + " = '" + train_id + "'");

        if (cursor != null) {
            Log.d("1234", "fetchDataMS: "+cursor.getCount());
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String Tno = cursor.getString(1);
                String msNAME = cursor.getString(2);
                String msDISTNCE = cursor.getString(3);
                String msTIME = cursor.getString(4);

                MidStationPojo pojo = new MidStationPojo();

                pojo.setTrainNO(Tno);
                pojo.setMsName(msNAME);
                pojo.setMsDistance(msDISTNCE);
                pojo.setMsTime(msTIME);

                Log.d("1234", "fetchDataMS: "+pojo.toString());

                msArray.add(pojo);
            }
            msAdapter.notifyDataSetChanged();
            cursor.close();
            db.close();
        }
    }

    private void listClick(final MidStationPojo rowID, int i) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Action");
        builder.setItems(new String[]{"Delete", "Update"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                if (position == 0) {
                    //delete(rowID);
                } else {
                    //update(rowId, listClickPosition);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

   /* private void delete(MidStationPojo rowId) {

        SQLiteDatabase db = new MySQLiteOpenHelper(this).getWritableDatabase();
        String selection = AddMidStationTAble.ID + " = '" + rowId + "'";

        if (AddMidStationTAble.delete(db, selection) > 0) {
            Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
           // fetchDataMS();
        } else {
            Toast.makeText(this, "not deleted", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }*/
}
