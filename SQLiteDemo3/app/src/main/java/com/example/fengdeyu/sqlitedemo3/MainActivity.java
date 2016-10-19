package com.example.fengdeyu.sqlitedemo3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper helper=new DBOpenHelper(MainActivity.this,"stu.db");

        SQLiteDatabase db=helper.getWritableDatabase();

        Cursor c =db.rawQuery("select * from stutb",null);

        if(c!=null){
            String[] cols=c.getColumnNames();

            while (c.moveToNext()){
                for(String ColumnName:cols){

                    Log.i("info",c.getString(c.getColumnIndex(ColumnName)));

                }


            }

            c.close();
        }

        db.close();

    }
}
