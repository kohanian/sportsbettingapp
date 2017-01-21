package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class NBAGame {

    String gameID;
    String homeID;
    String awayID;
    String homeName;
    String awayName;

    public NBAGame(String gameID, String homeID, String awayID, String homeName, String awayName) {
        this.gameID = gameID;
        this.homeID = homeID;
        this.awayID = awayID;
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getHomeID() {
        return homeID;
    }

    public void setHomeID(String homeID) {
        this.homeID = homeID;
    }

    public String getAwayID() {
        return awayID;
    }

    public void setAwayID(String awayID) {
        this.awayID = awayID;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }
}
