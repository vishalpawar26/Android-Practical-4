package com.example.practical4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataStore extends SQLiteOpenHelper {
    DataStore(Context context) {
        super(context, "StudentData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s1 = "create table registration (name text, contact_no text, dob text, email_id text, address text, password text)";

        db.execSQL(s1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean storeData(String s1, String s2, String s3, String s4, String s5, String s6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", s1);
        cv.put("contact_no", s2);
        cv.put("dob", s3);
        cv.put("email_id", s4);
        cv.put("address", s5);
        cv.put("password", s6);

        int i = (int)db.insert("registration", null, cv);

        Log.d("Inserted", "Inserted: " + i);

        return i > 0;
    }

    public boolean login(String s1, String s2) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("registration", new String[]{"email_id", "password"}, "email_id=? and password=?",
                new String[]{s1, s2}, null, null, null);

        return c.moveToFirst();
    }
}
