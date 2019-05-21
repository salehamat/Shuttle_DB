package com.example.shuttle_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper Helper= new MyHelper(this);
        SQLiteDatabase database= Helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT AID, LOCATION, TIME FROm EMPOYEES",new String[]{});

        if(cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder=new StringBuilder();
        do{
            String Aid =cursor.getString(0);
            String location=cursor.getString(1);
            String Time= cursor.getString(2);

            builder.append("AID=" + Aid +"LOCATION= "+ location+ "TIME= "+ Time);
        }while(cursor.moveToNext());

        TextView textView = findViewById(R.id.textData);
        textView.setText(builder.toString());
    }
}
