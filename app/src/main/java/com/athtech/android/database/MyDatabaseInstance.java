package com.athtech.android.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {UserTable.class}, version = 1)
public abstract class MyDatabaseInstance extends RoomDatabase {
    abstract UserDao getUserDao();
}
