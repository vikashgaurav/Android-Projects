package com.grv.vikash.smartrip.Table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by vikash on 26-06-2017.
 */

public class RegisterTable {

    public static final  String TABLE_NAME = "registerTable";

    public static final String ID = "id";
    public static final String FNAME = "firstName";
    public static final String LNAME = "lastName";
    public static final String EMAIL = "email";
    public static final String MOBILE = "mobile";
    public static final String PASSWORD = "password";

    public static final String CreateQuery = "CREATE TABLE `registerTable` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`firstName`\tTEXT,\n" +
            "\t`lastName`\tTEXT,\n" +
            "\t`email`\tTEXT UNIQUE,\n" +
            "\t`mobile`\tTEXT,\n" +
            "\t`password`\tTEXT\n" +
            ");";

    public static void CreateTable(SQLiteDatabase db){
        db.execSQL(CreateQuery);
        Log.d("abc", "CreateTable: Table Created");
    }

    public static void UpdateTable(SQLiteDatabase db){
        String UpdateQuery = "drop table if exists "+TABLE_NAME;
        db.execSQL(UpdateQuery);
        CreateTable(db);
        //Log.d("abc", "UpdateTable: Table Updated");
    }

    public static long insert(SQLiteDatabase db, ContentValues cv){
        return db.insert(TABLE_NAME,null,cv);
    }
    public static Cursor select(SQLiteDatabase db, String selction){
        return db.query(TABLE_NAME,null, selction, null, null, null, null, null);
    }
}
