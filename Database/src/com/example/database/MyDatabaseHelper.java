package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME="userdatabase.db";
	public static final int DATABASE_VERSION=1;

	public static final String TABLE_NAME="user";
	public static final String COLUMN_ID="id";
	public static final String COLUMN_FNAME="fname";
	public static final String COLUMN_LNAME="lname";
	public static final String COLUMN_EMAIL="email";
	public static final String COLUMN_PASSWORD="password";
	public static final String COLUMN_DOB_DAY="dob_day";
	public static final String COLUMN_DOB_MONTH="dob_month";
	public static final String COLUMN_DOB_YEAR="dob_year";
	public static final String COLUMN_GENDER="gender";
	public static final String COLUMN_PHONE="phone";

	public MyDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " 
				+TABLE_NAME
				+"("
				+COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
				+COLUMN_FNAME+" TEXT,"
				+COLUMN_LNAME+" TEXT,"
				+COLUMN_EMAIL+" TEXT,"
				+COLUMN_PASSWORD+" TEXT,"
				+COLUMN_DOB_DAY+" INTEGER,"
				+COLUMN_DOB_MONTH+" INTEGER,"
				+COLUMN_DOB_YEAR+" INTEGER,"
				+COLUMN_GENDER+" INTEGER,"
				+COLUMN_PHONE+" TEXT"
				+")"

				);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
	}

	public boolean doRegistration(String fname, String lname, String email, String password, int d, int mn, int year, int gender, String phn) {
		try {
			SQLiteDatabase db= this.getWritableDatabase();
			ContentValues values=new ContentValues();
			values.put(COLUMN_FNAME, fname);
			values.put(COLUMN_LNAME,lname);
			values.put(COLUMN_EMAIL, email);
			values.put(COLUMN_PASSWORD,password);
			values.put(COLUMN_DOB_DAY, d);
			values.put(COLUMN_DOB_MONTH, mn);
			values.put(COLUMN_DOB_YEAR, year);
			values.put(COLUMN_GENDER, gender);
			values.put(COLUMN_PHONE, phn);
			db.insert(TABLE_NAME, null, values);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	public boolean checkLogin(String user, String pass) {
if(COLUMN_EMAIL=="user"&& COLUMN_PASSWORD==pass){

}
else {
	return false;
}

		return true;
	}

	public boolean getDetails(String email) {
SQLiteDatabase db=this.getReadableDatabase();
Cursor c= db.rawQuery("SELECT * FROM" + TABLE_NAME, null);
	
db.close();
return true;
	}

}
