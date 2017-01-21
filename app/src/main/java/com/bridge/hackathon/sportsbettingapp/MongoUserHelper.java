package com.bridge.hackathon.sportsbettingapp;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class MongoUserHelper extends MongoHelper {

    MongoCollection<Document> collection;

    public MongoUserHelper() {
        super();
        referenceTable("users");
        this.collection = super.collection;
    }

    public void insertUser(String email) {

    }

}
