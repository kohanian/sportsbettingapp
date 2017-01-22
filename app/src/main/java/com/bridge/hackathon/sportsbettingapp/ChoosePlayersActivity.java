package com.bridge.hackathon.sportsbettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ChoosePlayersActivity extends AppCompatActivity {

    Spinner point, shoot, small, power, center;

    ArrayList<String> pointGuards = new ArrayList<String>();
    ArrayList<String> shootingGuards = new ArrayList<String>();
    ArrayList<String> smallForwards = new ArrayList<String>();
    ArrayList<String> powerForwards = new ArrayList<String>();
    ArrayList<String> centers = new ArrayList<String>();

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

        String dailyScheduleFooter ="/nba-t3/games/2017/01/22/schedule.xml?api_key=876nvvkv2s96b9ujt5596mc2";
        String scheduleJSON = "";

        try {
            scheduleJSON = new HttpRequestHandler().execute(dailyScheduleFooter).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        NBASchedulingHandler nbaSchedulingHandler = new NBASchedulingHandler(scheduleJSON);
        ArrayList<NBAGame> nbaGames = nbaSchedulingHandler.createNBAGamesList();
        for (int i = 0; i < nbaGames.size(); i++) {
            String homeID = nbaGames.get(i).getHomeID();
            String homeURL = "/nba-t3/teams/" + homeID + "/profile.xml?api_key=876nvvkv2s96b9ujt5596mc2";

            System.out.println("TEAM URL:::: " + homeURL);
            String homeJSON = "";

            try {
                homeJSON = new HttpRequestHandler().execute(homeURL).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            NBATeamHandler nbaTeamHandler = new NBATeamHandler(homeJSON);
            ArrayList<NBAPlayer> nbaPlayers = nbaTeamHandler.getNBAPlayers();

            for (int j = 0; j < nbaPlayers.size(); j++) {
                NBAPlayer player = nbaPlayers.get(j);
                if(player.getPrimaryPosition().equals("PG")) {
                    pointGuards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("SG")) {
                    shootingGuards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("SF")) {
                    smallForwards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("PF")) {
                    powerForwards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("C")) {
                    centers.add(player.firstName + " " + player.lastName);
                }
            }


            String awayID = nbaGames.get(i).getAwayID();
            String awayURL = "/nba-t3/teams/" + awayID + "/profile.xml?api_key=876nvvkv2s96b9ujt5596mc2";

            System.out.println("TEAM URL:::: " + awayURL);
            String awayJSON = "";


            try {
                awayJSON = new HttpRequestHandler().execute(awayURL).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




            NBATeamHandler nbaTeamHandler2 = new NBATeamHandler(awayJSON);
            nbaPlayers.clear();
            nbaPlayers = nbaTeamHandler2.getNBAPlayers();

            for (int j = 0; j < nbaPlayers.size(); j++) {
                NBAPlayer player = nbaPlayers.get(j);
                if(player.getPrimaryPosition().equals("PG")) {
                    pointGuards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("SG")) {
                    shootingGuards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("SF")) {
                    smallForwards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("PF")) {
                    powerForwards.add(player.firstName + " " + player.lastName);
                }
                else if(player.getPrimaryPosition().equals("C")) {
                    centers.add(player.firstName + " " + player.lastName);
                }
            }

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pointGuards);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, shootingGuards);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, smallForwards);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, powerForwards);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, centers);



        point.setAdapter(adapter1);
        shoot.setAdapter(adapter2);
        small.setAdapter(adapter3);
        power.setAdapter(adapter4);
        center.setAdapter(adapter5);



    }
}
