package com.bridge.hackathon.sportsbettingapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class NBATeamHandler {

    JsonArray listOfPlayers;

    String id;
    String alias;

    public NBATeamHandler(String json) {
        JsonParser parser = new JsonParser();
        JsonObject league = parser.parse(json).getAsJsonObject();
        JsonObject team = league.getAsJsonObject("team");
        String alias = team.get("alias").getAsString();
        this.alias = alias;
        String id = team.get("id").getAsString();
        this.id = id;
        JsonObject player = team.getAsJsonObject("players");
        listOfPlayers = player.getAsJsonArray("player");
    }

    public ArrayList<NBAPlayer> getNBAPlayers() {
        ArrayList<NBAPlayer> players = new ArrayList<>();
        for (int i = 0; i < listOfPlayers.size(); i++) {
            JsonObject jsonObject = (JsonObject) listOfPlayers.get(i);
            NBAPlayer nba = getNBAPlayer(jsonObject);
            players.add(nba);
        }
        return players;
    }

    public NBAPlayer getNBAPlayer(JsonObject jsonObject) {
        String primaryPosition = jsonObject.get("primary_position").getAsString();
        String firstName = jsonObject.get("first_name").getAsString();
        String lastName = jsonObject.get("last_name").getAsString();
        String id = jsonObject.get("id").getAsString();
        String jerseyNumber = jsonObject.get("jersey_number").getAsString();
        return new NBAPlayer(primaryPosition,firstName,lastName,id,jerseyNumber);
    }
}
