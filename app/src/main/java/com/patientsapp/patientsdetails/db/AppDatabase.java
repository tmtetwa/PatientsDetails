package com.patientsapp.patientsdetails.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.processor.Context;


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDoa();

    private static AppDatabase database;
    private static String DATABASE_NAME = "database";
    public static AppDatabase getInstance(Context context) {
        if(database == null)
        {
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
    public abstract UserDao userDao();
}
