package com.athtech.android.database;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.athtech.android.R;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataase);
        MyDatabaseInstance instance = Room.databaseBuilder(this, MyDatabaseInstance.class, "MyDB").allowMainThreadQueries().build();

        new DBRetrieveTask(instance).execute();

        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DbSaveBgtask(DatabaseActivity.this).execute();
                new DBRetrieveTask(instance).execute();
            }
        });

        SharedPreferences localPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("age", 100);
        editor.putInt("age", 100);
        editor.putInt("age", 100);
        editor.putInt("age", 100);
        editor.putInt("age", 100);
        editor.commit();
        editor.apply();

    }
}