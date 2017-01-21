package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class NBAPlayer {

    String primaryPosition;
    String firstName;
    String lastName;
    String id;
    String jerseyNumber;

    public NBAPlayer(String primaryPosition, String firstName, String lastName, String id, String jerseyNumber) {
        this.primaryPosition = primaryPosition;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.jerseyNumber = jerseyNumber;
    }

    public String getPrimaryPosition() {
        return primaryPosition;
    }

    public void setPrimaryPosition(String primaryPosition) {
        this.primaryPosition = primaryPosition;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
