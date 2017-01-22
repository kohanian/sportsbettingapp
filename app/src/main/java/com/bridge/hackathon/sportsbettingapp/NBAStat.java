package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class NBAStat {

    String playerID;
    String points;
    String rebounds;
    String assists;

    public NBAStat(String playerID, String points, String rebounds, String assists) {
        this.playerID = playerID;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
    }


    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getRebounds() {
        return rebounds;
    }

    public void setRebounds(String rebounds) {
        this.rebounds = rebounds;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }
}
