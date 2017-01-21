package com.bridge.hackathon.sportsbettingapp;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class MongoGameHelper extends MongoHelper {

    MongoCollection<Document> collection;

    public MongoGameHelper() {
        super();
        referenceTable("games");
        this.collection = super.collection;
    }

    public void insertGame(String player1, String player2, String state, String winner,
                           String player1Score, String player2Score) {

    }

    public void deleteGame(String id) {

    }

    public void updateGame(String id, String player1, String player2, String state, String winner,
                           String player1Score, String player2Score) {
        
    }
}
