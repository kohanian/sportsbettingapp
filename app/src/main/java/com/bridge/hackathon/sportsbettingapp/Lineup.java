package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class Lineup {

    public String pointGuardID;
    public String shootingGuardID;
    public String smallForwardID;
    public String powerForwardID;
    public String centerID;

    public Lineup(String pointGuardID, String shootingGuardID, String smallForwardID, String powerForwardID, String centerID) {
        this.pointGuardID = pointGuardID;
        this.shootingGuardID = shootingGuardID;
        this.smallForwardID = smallForwardID;
        this.powerForwardID = powerForwardID;
        this.centerID = centerID;
    }

    public String getPointGuardID() {
        return pointGuardID;
    }

    public void setPointGuardID(String pointGuardID) {
        this.pointGuardID = pointGuardID;
    }

    public String getShootingGuardID() {
        return shootingGuardID;
    }

    public void setShootingGuardID(String shootingGuardID) {
        this.shootingGuardID = shootingGuardID;
    }

    public String getSmallForwardID() {
        return smallForwardID;
    }

    public void setSmallForwardID(String smallForwardID) {
        this.smallForwardID = smallForwardID;
    }

    public String getPowerForwardID() {
        return powerForwardID;
    }

    public void setPowerForwardID(String powerForwardID) {
        this.powerForwardID = powerForwardID;
    }

    public String getCenterID() {
        return centerID;
    }

    public void setCenterID(String centerID) {
        this.centerID = centerID;
    }
}
