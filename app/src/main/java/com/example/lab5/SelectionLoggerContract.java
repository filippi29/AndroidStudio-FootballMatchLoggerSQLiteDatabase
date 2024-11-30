package com.example.lab5;


import android.provider.BaseColumns;

public final class SelectionLoggerContract {
    private SelectionLoggerContract(){};

    public static class LoggerEntry implements BaseColumns{
        public static final String TABLE_NAME = "Games";
        public static final String COLUMN_NAME_TEAM1 = "team1";
        public static final String COLUMN_NAME_TEAM2 = "team2";
        public static final String COLUMN_NAME_WINNER = "winner";
    }
}
