package com.example.multiplicationchallenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "highscores.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SCORE = "score";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SCORE = "score";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createScoreTableSql = "CREATE TABLE " + TABLE_SCORE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SCORE + " INTEGER )";
        db.execSQL(createScoreTableSql);
        Log.i("info", "created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);

    }

    public long insertScore(String name, Integer score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SCORE, score);
        long result = db.insert(TABLE_SCORE, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<HighScore> getAllScores() {
        ArrayList<HighScore> scores = new ArrayList<HighScore>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_NAME + ", " + COLUMN_SCORE + " FROM " + TABLE_SCORE + " ORDER BY " + COLUMN_SCORE + " DESC ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int score = cursor.getInt(2);
                HighScore highscore = new HighScore(id, name, score);
                scores.add(highscore);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return scores;
    }
}