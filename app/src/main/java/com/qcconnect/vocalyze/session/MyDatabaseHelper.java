package com.qcconnect.vocalyze.session;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "VocalizeDB";

    private static final int DATABASE_VERSION = 2;



    // Database creation sql statement
    private static final String USER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS users (email VARCHAR PRIMARY KEY, username VARCHAR, pass INTEGER);";
    private static final String MESSAGE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS messages (content VARCHAR,  sent TIMESTAMP,"+
            " message_id INTEGER NOT NULL PRIMARY KEY, FOREIGN KEY(sender) REFERENCES users(email));";
    private static final String MESSAGE_REC_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS messageRecp (message_id INTEGER PRIMARY KEY, FOREIGN KEY(user_id) REFERENCES users(email));";
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(USER_TABLE_CREATE);
        database.execSQL(MESSAGE_TABLE_CREATE);
        database.execSQL(MESSAGE_REC_TABLE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(MyDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS VocalizeDB");
        onCreate(database);
    }
}
