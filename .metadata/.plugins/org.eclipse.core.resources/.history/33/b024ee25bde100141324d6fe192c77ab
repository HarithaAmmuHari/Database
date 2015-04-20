package com.adarsh.runtimedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imrokraft on 12/3/15.
 */
public class dbhandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "mydb";
    public static final String TABLE_NAME = "mytb";

    public dbhandler(Context context) {
        super(context, DB_NAME, null, 32);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PLACE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public long insertdata(String nm, String pl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", nm);
        cv.put("place", pl);
        return db.insert(TABLE_NAME, null, cv);
       
    }

    public Cursor viewdata() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        db.close();
        return c;
    }
}
