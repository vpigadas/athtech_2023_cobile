package com.athtech.android.database;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class DBRetrieveTask extends AsyncTask<Void, Void, List<UserTable>> {

    private MyDatabaseInstance databaseInstance;

    public DBRetrieveTask(MyDatabaseInstance instance) {
        this.databaseInstance = instance;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserTable> doInBackground(Void... voids) {
        return databaseInstance.getUserDao().retrieve();
    }

    @Override
    protected void onPostExecute(List<UserTable> unused) {
        super.onPostExecute(unused);
        Log.d("Database", "Successful");
        Log.d("Database", "count=" + unused.size());
    }
}
