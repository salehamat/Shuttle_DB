package com.example.shuttle_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname ="shuttleDB";
    private static final int version=1;

    public MyHelper(Context context){
        super(context, dbname, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // write logic to create tables and all..
        String sql= "CREATE TABLE EMPLOYEES (_id INTEGER PRIMARY KEY AUTOINCREMENT, AID String, LOCATION String, TIME String)";
        db.execSQL(sql);

        //insert logic
        insertData("a0230514","TII","May20-2019", db);
    }
    private void insertData(String aid, String Location, String Time, SQLiteDatabase database ){
        ContentValues values= new ContentValues();
        values.put("AID", aid);
        values.put("LOCATION", Location);
        values.put("TIME",Time);
        database.insert("EMPLOYEES",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
