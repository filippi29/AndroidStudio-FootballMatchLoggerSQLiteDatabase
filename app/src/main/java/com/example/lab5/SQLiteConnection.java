package com.example.lab5;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class SQLiteConnection {
    private SelectionLoggerDbHelper dbHelper;
    private SQLiteDatabase db;

    SQLiteConnection(Context context){
        dbHelper = new SelectionLoggerDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(String team1, String team2, String winner){

        ContentValues values = new ContentValues();
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TEAM1, team1);
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TEAM2, team2);
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_WINNER, winner);

        long newRowId = db.insert(SelectionLoggerContract.LoggerEntry.TABLE_NAME, null, values);
        return newRowId;

    }

    public void close(){
        db.close();
    }
}

