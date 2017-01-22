package com.bridge.hackathon.sportsbettingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private ListView lvGame;
    private GameListAdapter adapter;
    private List<Game> mGameList;
    static HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
    }
}


// Reference Video : https://youtu.be/YMJSBHAZsso

