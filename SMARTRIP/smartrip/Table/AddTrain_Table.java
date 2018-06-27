package com.grv.vikash.smartrip.Table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by vikash on 01-07-2017.
 */

public class AddTrain_Table {

    public static final String TRAIN_TABLE_NAME= "train_detail";

    public static final String NO = "no";
    public static final String NAME = "name";
    public static final String DESTINATION = "destination";
    public static final String SOURCE = "source";
    public static final String START_TIME = "startTime";
    public static final String TOTAL_TIME = "totalTime";
    public static final String TOTAL_kMS = "totalKms";
    public static final String SUN = "sun";
    public static final String MON = "mon";
    public static final String TUE = "tue";
    public static final String WED = "wed";
    public static final String THU = "thu";
    public static final String FRI = "fri";
    public static final String SAT = "sat";

    public static final String createQuery = "CREATE TABLE `train_detail` (\n" +
            "\t`no`\tTEXT UNIQUE,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`source`\tTEXT,\n" +
            "\t`destination`\tTEXT,\n" +
            "\t`startTime`\tTEXT,\n" +
            "\t`totalTime`\tTEXT,\n" +
            "\t`totalKms`\tTEXT,\n" +
            "\t`sun`\tTEXT,\n" +
            "\t`mon`\tTEXT,\n" +
            "\t`tue`\tTEXT,\n" +
            "\t`wed`\tTEXT,\n" +
            "\t`thu`\tTEXT,\n" +
            "\t`fri`\tTEXT,\n" +
            "\t`sat`\tTEXT,\n" +
            "\tPRIMARY KEY(`no`)\n" +
            ");";

    public static void createTrainTable(SQLiteDatabase db) {
        db.execSQL(createQuery);
        Log.d("abc", "createTable: Train table created");
    }

    public static void updateTrainTable(SQLiteDatabase db)
    {
        String updateQuery = "drop table if exists "+TRAIN_TABLE_NAME;
        db.execSQL(updateQuery);
        createTrainTable(db);
        Log.d("abc", "updateTrainTable: Train table updated");
    }


    public static long insert(SQLiteDatabase db, ContentValues cv)
    {
        return db.insert(TRAIN_TABLE_NAME, null, cv);
    }

    public static Cursor select(SQLiteDatabase db, String selection)
    {
        return db.query(TRAIN_TABLE_NAME, null, selection, null, null, null, null,null);
    }

    public static int delete(SQLiteDatabase db, String whereClause)
    {
        return db.delete(TRAIN_TABLE_NAME, whereClause, null);
    }

    public static int update(SQLiteDatabase db, ContentValues cv, String selection)
    {
        return db.update(TRAIN_TABLE_NAME , cv, selection, null);
    }
}
