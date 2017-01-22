package com.bridge.hackathon.sportsbettingapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class GameSummaryHandler {


    JsonArray listOfTeams;

    public GameSummaryHandler(String json) {
        JsonParser parser = new JsonParser();
        JsonObject game = parser.parse(json).getAsJsonObject();
        JsonObject game2 = game.getAsJsonObject("game");
        listOfTeams = game2.getAsJsonArray("team");
    }


    public ArrayList<NBAStat> getStatsInGame() {
        ArrayList<NBAStat> stats = new ArrayList<NBAStat>();
        for(int i = 0; i < listOfTeams.size(); i++) {
            JsonObject jsonObject = (JsonObject)listOfTeams.get(i);
            JsonObject players = jsonObject.getAsJsonObject("players");
            JsonArray playersArray = players.getAsJsonArray("player");
            for(int j = 0; j < playersArray.size(); j++) {
                JsonObject object = (JsonObject)playersArray.get(j);
                String id = object.get("id").getAsString();
                JsonObject statistics = object.getAsJsonObject("statistics");
                String points = statistics.get("points").getAsString();
                String rebounds = statistics.get("rebounds").getAsString();
                String assists = statistics.get("assists").getAsString();
                NBAStat stat = new NBAStat(id,points,rebounds,assists);
                stats.add(stat);

            }
        }
        return stats;
    }

}
