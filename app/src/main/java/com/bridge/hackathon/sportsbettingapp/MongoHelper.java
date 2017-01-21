package com.bridge.hackathon.sportsbettingapp;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
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

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public MongoHelper() {
        getConnection();
    }

    public void getConnection() {
        Resources resources = Resources.getSystem();
        String username = resources.getString(R.string.mongo_username);
        String password = resources.getString(R.string.mongo_password);
        String uri = String.format("mongodb://%s:%s@sportsbetting-shard-00-00-3acwu.mongodb.net:27017,sportsbetting-shard-00-01-3acwu.mongodb.net:27017,sportsbetting-shard-00-02-3acwu.mongodb.net:27017/admin?ssl=true&replicaSet=SportsBetting-shard-0&authSource=admin",
                username,password);
        mongoClient = new MongoClient(uri);
        String databaseName = resources.getString(R.string.mongo_database);
        database = mongoClient.getDatabase(databaseName);
    }


    public void referenceTable(String tableName) {
        collection = database.getCollection(tableName);
    }



}
