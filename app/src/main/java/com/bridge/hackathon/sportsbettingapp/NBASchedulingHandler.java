package com.bridge.hackathon.sportsbettingapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class NBASchedulingHandler {

    JsonArray listOfGames;

    public NBASchedulingHandler(String json) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject league = parser.parse(json).getAsJsonObject();
//        JsonObject league = (JsonObject) gson.fromJson(jsonPrettyPrintString,Object.class);
        JsonObject league2 = league.getAsJsonObject("league");
        JsonObject dailySchedule = league2.getAsJsonObject("daily-schedule");
        JsonObject game = dailySchedule.getAsJsonObject("games");
        listOfGames = game.getAsJsonArray("game");
    }


    public ArrayList<NBAGame> createNBAGamesList() {
        ArrayList<NBAGame> nbaGames = new ArrayList<>();
        for(int i = 0; i < listOfGames.size(); i++) {
            JsonObject object = (JsonObject)listOfGames.get(0);
            NBAGame nbaGame = getNBAGame(object);
            nbaGames.add(nbaGame);
        }
        return nbaGames;
    }

    public NBAGame getNBAGame(JsonObject jsonObject) {
        JsonElement id = jsonObject.get("id");
        String stringID = id.getAsString();

        JsonObject homeTeam = jsonObject.getAsJsonObject("home");
        String homeID = homeTeam.get("id").getAsString();
        String homeName = homeTeam.get("name").getAsString();

        JsonObject awayTeam = jsonObject.getAsJsonObject("away");
        String awayID = homeTeam.get("id").getAsString();
        String awayName = homeTeam.get("name").getAsString();


        NBAGame nbaGame = new NBAGame(stringID,homeID,awayID,homeName,awayName);
        return nbaGame;
    }








}
