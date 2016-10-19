package com.example.fengdeyu.sqlitedemo3;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fengdeyu on 2016/10/3.
 */
//15170798499

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
        db.execSQL("insert into stutb(name,sex,age)values('张三','女',18)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
