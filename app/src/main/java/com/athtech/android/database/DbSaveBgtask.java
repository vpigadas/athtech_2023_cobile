package com.athtech.android.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import java.util.Random;

public class DbSaveBgtask extends AsyncTask<Void, Void, Void> {

    private Context context;

    public DbSaveBgtask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        MyDatabaseInstance instance = Room.databaseBuilder(context, MyDatabaseInstance.class, "MyDB").build();
        instance.getUserDao().save(getInstance());
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        Log.d("Database", "Successful");
    }


    UserTable getInstance() {
        String name = new Random().toString();
        int age = 100;
        String joType = "";

        UserTable table = new UserTable();
        table.setName(name);
        table.setAge(age);
        table.setJobType(joType);

        return table;
    }
}
