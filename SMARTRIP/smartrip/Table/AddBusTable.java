package com.grv.vikash.smartrip.Table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by vikash on 12-07-2017.
 */

public class AddBusTable {
    public static final String BUS_TABLE_NAME = "busTable";

    public static final String TABLE_ID = "id";
    public static final String BUSAGENCTY = "busAgency";
    public static final String BUSTYPE = "busType";
    public static final String BUS_SOURCE = "busSource";
    public static final String BUS_DESTINATION = "busDestination";
    public static final String BUS_STARTTIME = "busStartTime";
    public static final String BUS_ENDTIME = "busEndTime";
    public static final String BUS_TOTALTIME = "totalTime";
    public static final String BUS_SEAT = "busSeat";
    public static final String BUS_FARE = "busFare";

    public static String createQuery = "CREATE TABLE `busTable` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`busAgency`\tTEXT,\n" +
            "\t`busType`\tTEXT,\n" +
            "\t`busSource`\tTEXT,\n" +
            "\t`busDestination`\tTEXT,\n" +
            "\t`busStartTime`\tTEXT,\n" +
            "\t`busEndTime`\tTEXT,\n" +
            "\t`totalTime`\tTEXT,\n" +
            "\t`busSeat`\tTEXT,\n" +
            "\t`busFare`\tTEXT\n" +
            ");";
    public static void createBusTable(SQLiteDatabase db) {
        db.execSQL(createQuery);
    }

    public static void updateBusTable(SQLiteDatabase db)
    {
        String updateQuery = "drop table if exists "+BUS_TABLE_NAME;
        db.execSQL(updateQuery);
        createBusTable(db);
    }


    public static long insert(SQLiteDatabase db, ContentValues cv)
    {
        return db.insert(BUS_TABLE_NAME, null, cv);
    }

    public static Cursor select(SQLiteDatabase db, String selection)
    {
        return db.query(BUS_TABLE_NAME, null, selection, null, null, null, null,null);
    }

    public static int delete(SQLiteDatabase db, String whereClause)
    {
        return db.delete(BUS_TABLE_NAME, whereClause, null);
    }

    public static int update(SQLiteDatabase db, ContentValues cv, String selection)
    {
        return db.update(BUS_TABLE_NAME , cv, selection, null);
    }
}
