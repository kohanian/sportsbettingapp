package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LiveGameRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game_room);


        Button btnToNext = (Button) findViewById(R.id.button3);

        btnToNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(),PointsTableCalculateActivity.class);
                startActivity(intent);
            }

        });

        Button btnToNext1 = (Button) findViewById(R.id.button2);

        btnToNext1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(getApplicationContext(),PointsTableCalculateActivity.class);
                startActivity(intent1);
            }

        });
    }


}
