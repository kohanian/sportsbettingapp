package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity {

    String userEmail;

    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent currentIntent = getIntent();

        userEmail = currentIntent.getStringExtra("currentUserEmail");

        email = (TextView)findViewById(R.id.textView);
        email.setText(userEmail);

    }
}
