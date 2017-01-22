package com.bridge.hackathon.sportsbettingapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyleohanian on 1/22/17.
 */

public class FirebaseUser {

    public FirebaseUser(String id, String email) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReferenceFromUrl("https://sportsbetting-14c48.firebaseio.com/");
        DatabaseReference smallRef = myRef.child("users");
        DatabaseReference numberRef = smallRef.child(id);
        User user = new User(email,"0","0");
        numberRef.setValue(user);

    }
}
