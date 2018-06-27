package com.grv.vikash.smartrip.Table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by vikash on 05-07-2017.
 */

public class AddMidStationTAble {
    public static final  String MID_TABLE_NAME = "mid_stationTable";

    public static final String ID = "id";
    public static final String TRAIN_NO = "train_no";
    public static final String MID_STATION = "mid_station";
    public static final String TOTAL_TIME = "total_time";
    public static final String TOTAL_DISTANCE = "total_distance";


    public static final String createTable = "CREATE TABLE `mid_stationTable` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`train_no`\tTEXT,\n" +
            "\t`mid_station`\tTEXT,\n" +
            "\t`total_time`\tTEXT,\n" +
            "\t`total_distance`\tTEXT\n" +
            ");";

    public static void createMidTable(SQLiteDatabase db){
        db.execSQL(createTable);
    }

    public static void updateMidTable(SQLiteDatabase db){
        String updateQuery = "drop table if exists "+MID_TABLE_NAME;
        db.execSQL(updateQuery);
        createMidTable(db);
        Log.d("abc", "updateMidTable: Mid table updated");
    }
    public static long insert(SQLiteDatabase db, ContentValues cv)
    {
        return db.insert(MID_TABLE_NAME, null, cv);
    }

    public static Cursor select(SQLiteDatabase db, String selection)
    {
        return db.query(MID_TABLE_NAME, null, selection, null, null, null, null,null);
    }

    public static int delete(SQLiteDatabase db, String whereClause)
    {
        return db.delete(MID_TABLE_NAME, whereClause, null);
    }

    public static int update(SQLiteDatabase db, ContentValues cv, String selection)
    {
        return db.update(MID_TABLE_NAME , cv, selection, null);
    }
}
