package com.vk.vktestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.vk.vktestapp.com.models.Distway;
import com.google.gson.Gson;

public class DistwayActivity extends Activity {

    TextView name = null;
    TextView note = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payway);

        Intent intent = getIntent();
        Gson gson = new Gson();

        Distway distway = gson.fromJson(intent.getStringExtra("distway"), Distway.class);

        name = (TextView)findViewById(R.id.name);
        note = (TextView)findViewById(R.id.note);

        name.setText(distway.getName());
        note.setText(distway.getNote());

    }
}
