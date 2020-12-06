package com.example.giftapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Gift.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase theDB = null;

    public abstract GiftDao giftDao();

    public static AppDatabase createInstance(Context context) {
        if (theDB == null) {
            theDB = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"thedata").allowMainThreadQueries().build();
        }
        return theDB;
    }

    public static AppDatabase getInstance(){
        return theDB;
    }
}

