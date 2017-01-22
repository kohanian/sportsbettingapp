package com.bridge.hackathon.sportsbettingapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyleohanian on 1/22/17.
 */

public class FirebaseGame {

    public FirebaseGame(String player1, String player2, String amount) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReferenceFromUrl("https://sportsbetting-14c48.firebaseio.com/");
        DatabaseReference smallRef = myRef.child("games");
        Game game = new Game("1", player1, player2, amount, "Test");
        String id = "1";
        Map<String, Object> listOfGames = new HashMap<String, Object>();
        listOfGames.put(id,game);
        smallRef.setValue(listOfGames);
    }
}
