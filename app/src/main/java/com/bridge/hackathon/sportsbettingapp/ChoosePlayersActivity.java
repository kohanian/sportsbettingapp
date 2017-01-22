package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoosePlayersActivity extends AppCompatActivity {

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
    }
}
