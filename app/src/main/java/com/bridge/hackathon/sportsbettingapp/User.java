package com.bridge.hackathon.sportsbettingapp;

import java.util.HashMap;

/**
 * Created by kyleohanian on 1/22/17.
 */

public class User {

    String email;
    String wins;
    String losses;

    public User(String email, String wins, String losses) {
        this.email = email;
        this.wins = wins;
        this.losses = losses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }
}
