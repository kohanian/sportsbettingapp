package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kimeric on 1/21/17.
 */

public class Game {
    private String id;
    //profile image from faceobok
    private String player1;
    private String player2;
    private String amount;


    private String teamName1;
    private String teamName2;

    private String date;

    private Lineup lineup1;
    private Lineup lineup2;


    //private int record;

    //constructor
    public Game(String id, String player1, String player2, String amount, String date){
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.amount = amount;
        this.date = date;
        this.lineup1 = null;
        this.lineup2 = null;
    }

    // Setter and getter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getTeamName1() {
        return teamName1;
    }

    public void setTeamName1(String teamName1) {
        this.teamName1 = teamName1;
    }

    public String getTeamName2() {
        return teamName2;
    }

    public void setTeamName2(String teamName2) {
        this.teamName2 = teamName2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Lineup getLineup1() {
        return lineup1;
    }

    public void setLineup1(Lineup lineup1) {
        this.lineup1 = lineup1;
    }

    public Lineup getLineup2() {
        return lineup2;
    }

    public void setLineup2(Lineup lineup2) {
        this.lineup2 = lineup2;
    }
}
