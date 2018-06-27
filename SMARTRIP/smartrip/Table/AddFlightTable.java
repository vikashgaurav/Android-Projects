package com.grv.vikash.smartrip.Table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by vikash on 03-07-2017.
 */

public class AddFlightTable {

    public static final String Flight_TABLE_NAME= "flight_table";

    public static final String ID = "id";
    public static final String FNO = "fno";
    public static final String FNAME = "fname";
    public static final String FDESTINATION = "fdestination";
    public static final String FSOURCE = "fsource";
    public static final String FSTART_TIME = "fstartTime";
    public static final String FEND_TIME = "fendTime";
    public static final String FARE = "ffare";
    public static final String SUN = "fsun";
    public static final String MON = "fmon";
    public static final String TUE = "ftue";
    public static final String WED = "fwed";
    public static final String THU = "fthu";
    public static final String FRI = "ffri";
    public static final String SAT = "fsat";

    public static String  createQuery = "CREATE TABLE `flight_table` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`fname`\tTEXT,\n" +
            "\t`fno`\tTEXT UNIQUE,\n" +
            "\t`fsource`\tTEXT,\n" +
            "\t`fdestination`\tTEXT,\n" +
            "\t`fstartTime`\tTEXT,\n" +
            "\t`fendTime`\tTEXT,\n" +
            "\t`fsun`\tTEXT,\n" +
            "\t`fmon`\tTEXT,\n" +
            "\t`ftue`\tTEXT,\n" +
            "\t`fwed`\tTEXT,\n" +
            "\t`fthu`\tTEXT,\n" +
            "\t`ffri`\tTEXT,\n" +
            "\t`fsat`\tTEXT,\n" +
            "\t`ffare`\tTEXT\n" +
            ");";


    public static void createFlightTable(SQLiteDatabase db) {
        db.execSQL(createQuery);
        Log.d("abc", "createTable: Flight table created");
    }

    public static void updateFlightTable(SQLiteDatabase db)
    {
        String updateQuery = "drop table if exists "+Flight_TABLE_NAME;
        db.execSQL(updateQuery);
        createFlightTable(db);
        Log.d("abc", "updateFlightTable: Flight table updated");
    }


    public static long insert(SQLiteDatabase db, ContentValues cv)
    {
        return db.insert(Flight_TABLE_NAME, null, cv);
    }

    public static Cursor select(SQLiteDatabase db, String selection)
    {
        return db.query(Flight_TABLE_NAME, null, selection, null, null, null, null,null);
    }

    public static int delete(SQLiteDatabase db, String whereClause)
    {
        return db.delete(Flight_TABLE_NAME, whereClause, null);
    }

    public static int update(SQLiteDatabase db, ContentValues cv, String selection)
    {
        return db.update(Flight_TABLE_NAME , cv, selection, null);
    }
}
