package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);


        // button to next page (ChoosePlayersActivity)
        Button btnToNext = (Button) findViewById(R.id.button5_id);

        btnToNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(),ChoosePlayersActivity.class);
                startActivity(intent);
            }

        });

        final Button button4 = (Button) findViewById(R.id.button4_id);
        final Button button3 = (Button) findViewById(R.id.button3_id);
        final Button button2 = (Button) findViewById(R.id.button2_id);
        final EditText editText = (EditText)findViewById(R.id.editText);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                editText.setText("$20.00");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                editText.setText("$10.00");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                editText.setText("$1.00");
            }
        });
    }
}
