package com.example.applicineenigma;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName";
    public static final String APPLI_CINE_NAME="AppliCine";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table " + APPLI_CINE_NAME + "(id integer primary key, titre_du_film text, date_heure_projection text, note_scenario text, note_réalisation text, note_musique text, zone_description_critique text)"
        );

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + APPLI_CINE_NAME);
        onCreate(db);
    }
    public boolean insert(String s, Integer s1, Integer s2, Integer s3, Integer s4, String s5){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titre_du_film", s);
        contentValues.put("date_heure_projection", s1);
        contentValues.put("note_scenario", s2);
        contentValues.put("note_réalisation", s3);
        contentValues.put("note_musique", s4);
        contentValues.put("zone_description_critique", s5);
       db.insert(APPLI_CINE_NAME, null, contentValues);
       return true;
    }
}
