package com.bridge.hackathon.sportsbettingapp;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class HttpRequestHandler extends AsyncTask<String, Void, String> {
    String request;
    String jsonPrettyPrintString;


    private Exception exception;


    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;

        String urlFooter = params[0];

        try {
            String urlBase = "http://api.sportradar.us";
            URL url = new URL(urlBase + urlFooter);
            System.out.println("URL:: " + urlBase + urlFooter);

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            StringBuilder result = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            System.out.println("Request Received");
            request = result.toString();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL");
            this.exception = e;
            return null;
        } catch (IOException e) {
            System.out.println("IO Exception");
            this.exception = e;
            return null;
        }
        String json = "";
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(request);
            jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
            json = jsonPrettyPrintString;
            Log.d("JSON String:::: ",json);
//            return jsonPrettyPrintString;
        } catch (JSONException je) {
            this.exception = je;
            return null;
        }
        connection.disconnect();
        return jsonPrettyPrintString;
    }


//    String footer = "/nba-t3/teams/583eca2f-fb46-11e1-82cb-f4ce4684ea4c/profile.xml?api_key=876nvvkv2s96b9ujt5596mc2";

//    try {
//        String output = new HttpRequestHandler().execute(footer).get();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    } catch (ExecutionException e) {
//        e.printStackTrace();
//    }
}
