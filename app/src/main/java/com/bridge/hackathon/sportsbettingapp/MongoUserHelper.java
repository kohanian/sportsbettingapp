package com.bridge.hackathon.sportsbettingapp;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

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
        BasicDBList games = new BasicDBList();
        Document document = new Document("facebookEmail",
                email).append("games",games);
        collection.insertOne(document);
    }

    public void deleteUser(String email) {
        Bson filter = Filters.eq("email",email);
        collection.deleteOne(filter);
    }

    public List<Document> getUsers() {
        return (List<Document>)collection.find().into(new ArrayList<Document>());
    }





}
