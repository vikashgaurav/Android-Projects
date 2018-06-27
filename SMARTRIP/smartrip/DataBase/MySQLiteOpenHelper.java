package com.grv.vikash.smartrip.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.grv.vikash.smartrip.Table.AddBusTable;
import com.grv.vikash.smartrip.Table.AddFlightTable;
import com.grv.vikash.smartrip.Table.AddMidStationTAble;
import com.grv.vikash.smartrip.Table.AddTrain_Table;
import com.grv.vikash.smartrip.Table.RegisterTable;

/**
 * Created by vikash on 26-06-2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private Context context;
    public MySQLiteOpenHelper(Context context) {
        super(context, "mydb.db", null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        RegisterTable.CreateTable(sqLiteDatabase);
        AddTrain_Table.createTrainTable(sqLiteDatabase);
        AddFlightTable.createFlightTable(sqLiteDatabase);
        AddMidStationTAble.createMidTable(sqLiteDatabase);
        AddBusTable.createBusTable(sqLiteDatabase);
        Toast.makeText(context, "This is OnCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Toast.makeText(context, "DataBase Updated", Toast.LENGTH_SHORT).show();
        RegisterTable.UpdateTable(sqLiteDatabase);
        AddFlightTable.updateFlightTable(sqLiteDatabase);
        AddTrain_Table.updateTrainTable(sqLiteDatabase);
        AddMidStationTAble.updateMidTable(sqLiteDatabase);
        AddBusTable.updateBusTable(sqLiteDatabase);
    }
}