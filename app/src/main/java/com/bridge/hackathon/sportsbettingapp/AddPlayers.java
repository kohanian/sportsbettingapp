package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kimeric on 1/21/17.
 */

public class AddPlayers extends GameActivity {
    public String addPlayers (String email, String token) {
        if (data.get(token).size() != 2) {
            data.get(token).add(email);
            return "Success";
        } else {
            return "Failure";
        }
    }

}
