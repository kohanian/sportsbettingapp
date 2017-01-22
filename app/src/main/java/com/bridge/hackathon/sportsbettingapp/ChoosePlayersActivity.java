package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ChoosePlayersActivity extends AppCompatActivity {

    Spinner point, shoot, small, power, center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_players);

        // button to next page (LiveGameRoom)
        Button btnToNext = (Button) findViewById(R.id.button8);

        btnToNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(),LiveGameRoomActivity.class);
                startActivity(intent);
            }

        });

        point = (Spinner)findViewById(R.id.spinner);
        shoot = (Spinner)findViewById(R.id.spinner2);
        small = (Spinner)findViewById(R.id.spinner3);
        power = (Spinner)findViewById(R.id.spinner4);
        center = (Spinner)findViewById(R.id.spinner5);
    }
}
