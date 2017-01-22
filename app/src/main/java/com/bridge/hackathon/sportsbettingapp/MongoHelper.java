package com.bridge.hackathon.sportsbettingapp;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class MongoHelper {

    MongoDatabase database = null;
    MongoCollection<Document> collection = null;

    public MongoHelper() {
        Resources resources = Resources.getSystem();
//        String username = resources.getString("kohanian89");
//        String password = resources.getString("wWFoMpgtcq9T3rq5");
        String username = "kohanian89";
        String password = "wWFoMpgtcq9T3rq5";
//        String uri = String.format("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin",
//                username,password);
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
//        String databaseName = resources.getString(R.string.mongo_database);
        String databaseName = "SportsBetting";
        database = mongoClient.getDatabase("SportsBetting");
    }

    public void getConnection() {
        Resources resources = Resources.getSystem();
//        String username = resources.getString("kohanian89");
//        String password = resources.getString("wWFoMpgtcq9T3rq5");
        String username = "kohanian89";
        String password = "wWFoMpgtcq9T3rq5";
//        String uri = String.format("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin",
//                username,password);
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://kohanian89:wWFoMpgtcq9T3rq5@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
//        String databaseName = resources.getString(R.string.mongo_database);
        String databaseName = "SportsBetting";
        database = mongoClient.getDatabase("SportsBetting");
    }


    public void referenceTable(String tableName) {
        collection = database.getCollection(tableName);
    }



}
