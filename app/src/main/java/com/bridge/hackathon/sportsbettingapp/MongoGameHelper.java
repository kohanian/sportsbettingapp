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
                           String player1Score, String player2Score, Lineup lineup1, Lineup lineup2) {
        Document document = new Document("player1",player1).append("player2",player2).append("state",
                state).append("winner",winner).append("player1Score",player1Score).append("player2Score",
                player2Score).append("lineup1",lineup1).append("lineup2",lineup2);
        collection.insertOne(document);

    }

    public void deleteGame(String id) {

    }

    public void updateGame(String id, String player1, String player2, String state, String winner,
                           String player1Score, String player2Score) {
        
    }
}
