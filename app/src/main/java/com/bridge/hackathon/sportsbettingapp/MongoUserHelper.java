package com.bridge.hackathon.sportsbettingapp;

import android.content.res.Resources;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class MongoUserHelper {

    MongoCollection<Document> collection;

    public MongoUserHelper() {
        Resources resources = Resources.getSystem();
//        String username = resources.getString("kohanian89");
//        String password = resources.getString("wWFoMpgtcq9T3rq5");
        String username = "kohanian89";
        String password = "wWFoMpgtcq9T3rq5";
//        String uri = String.format("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin",
//                username,password);
        //MongoClientURI mongoClientURI = new MongoClientURI("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin");
        //MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoClientURI uri = new MongoClientURI("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin");

        MongoClient mongoClient = new MongoClient(uri);
        //MongoDatabase database = mongoClient.getDatabase("test");

//        String databaseName = resources.getString(R.string.mongo_database);
        String databaseName = "SportsBetting";
        MongoDatabase database = mongoClient.getDatabase("SportsBetting");
        this.collection = database.getCollection("users");
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

    public boolean exists(String email) {
        Bson filter = Filters.eq("email",email);
        FindIterable<Document> potent = collection.find(filter);
        MongoCursor<Document> cursor = potent.iterator();
        int sum = 0;
        while(cursor.hasNext()) {
            sum++;
        }
        cursor.close();
        if(sum == 0) {
            return false;
        }
        else {
            return true;
        }
    }





}
