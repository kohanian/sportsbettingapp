package com.bridge.hackathon.sportsbettingapp;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class HttpRequestHandler {
    String request;


    public HttpRequestHandler() {
        HttpURLConnection connection = null;

        try {
            String urlBase = "http://api.sportradar.us";
            String urlFooter = "/nba-t3/seasontd/2016/REG/rankings.xml?api_key=876nvvkv2s96b9ujt5596mc2";
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
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
    }

    public String xmlToJson() {
        String json = "";
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(request);
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
            json = jsonPrettyPrintString;
        } catch (JSONException je) {
            System.out.println(je.toString());
        }

        return json;
    }

}
