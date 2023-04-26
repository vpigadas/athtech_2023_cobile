package com.athtech.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.athtech.android.network.NetworkActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button btn = findViewById(R.id.login_btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("App", "The button clicked!!!");
                Snackbar.make(v, "The button clicked!!!", Snackbar.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,  NetworkActivity.class);
                intent.putExtra("name", "Vassili");
                intent.putExtra("age", 100);
                startActivityForResult(intent,5000);
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("App", "The button long clicked!!!");
                Toast.makeText(MainActivity.this, "The button long clicked!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
