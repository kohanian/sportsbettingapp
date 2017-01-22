package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GameActivity extends AppCompatActivity {

    private ListView lvGame;
    private GameListAdapter adapter;
    private List<Game> mGameList;
    static HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();

    String userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent currentIntent = getIntent();
        userEmail = currentIntent.getStringExtra("currentUserEmail");


        FirebaseUser firebaseUser = new FirebaseUser(userEmail);

        FirebaseGame firebaseGame = new FirebaseGame("1","2","10");


        // button to next page (create game)
        Button btnToCreateGame = (Button) findViewById(R.id.button9);

        btnToCreateGame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }

        });

        lvGame = (ListView)findViewById(R.id.listview_game);
        mGameList = new ArrayList<>();

        //Add Sample data for list
        //We can get data from DB, AppService here
        mGameList.add(new Game("1", "Bobby", "Eric", "100","Test"));
        mGameList.add(new Game("2", "Eric", "Kyle", "50","Test"));
        mGameList.add(new Game("3", "Kyle", "Bobby", "20","Test"));

        // Init Adapter
        adapter = new GameListAdapter(getApplicationContext(), mGameList);
        lvGame.setAdapter(adapter);


        lvGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //do sometihng
                //EX : display message with
                Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG);
            }
        });
//        lvGame.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                //do sometihng
//                //EX : display message with
//                Toast.makeText(getApplicationContext(), "Clicked Game id =" + view.getTag(), Toast.LENGTH_SHORT).show();
//            }
//        }

        String footer = "/nba-t3/games/d470c0a2-c2fa-450e-9b65-70328a4b7efa/summary.xml?api_key=876nvvkv2s96b9ujt5596mc2";
        try {
            String output = new HttpRequestHandler().execute(footer).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


// Reference Video : https://youtu.be/YMJSBHAZsso

