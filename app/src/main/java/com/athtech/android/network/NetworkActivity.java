package com.athtech.android.network;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.athtech.android.R;
import com.google.gson.Gson;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://dog.ceo/api/breeds/list/all";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        JsonElement json = new Gson().fromJson(response, JsonElement.class);
                        JsonResponse jsonResponse = new Gson().fromJson(response, JsonResponse.class);
                        Log.d("APP", response);

                        TextView textView = findViewById(R.id.text);
                        textView.setText(jsonResponse.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("APP", error.getLocalizedMessage());
                    }
                });

        queue.add(request);
    }
}