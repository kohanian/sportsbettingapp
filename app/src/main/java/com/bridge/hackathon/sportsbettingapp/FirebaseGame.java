package com.bridge.hackathon.sportsbettingapp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyleohanian on 1/22/17.
 */

public class FirebaseGame {

    int childrenCount = 0;

    public FirebaseGame(final String gameID, final String player1, final String player2, final String amount) {
//        getNumberOfGames(new FirebaseHandler() {
//            @Override
//            public void onSuccess(DataSnapshot dataSnapshot) {
//
//            }
//        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReferenceFromUrl("https://sportsbetting-14c48.firebaseio.com/");
        DatabaseReference smallRef = myRef.child("games");
        DatabaseReference numberRef = smallRef.child(gameID);
        Game game = new Game(gameID, player1, player2, amount, "Test");
        numberRef.setValue(game);
    }

    public void getNumberOfGames(final FirebaseHandler callback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReferenceFromUrl("https://sportsbetting-14c48.firebaseio.com/");
//        DatabaseReference smallRef = myRef.child("games");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                childrenCount = (int) dataSnapshot.getChildrenCount();
                System.out.println(childrenCount);
                callback.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
