package com.bridge.hackathon.sportsbettingapp;

/**
 * Created by kimeric on 1/21/17.
 */

public class Game {
    private int id;
    //profile image from faceobok
    private String player1;
    private String player2;
    private int amount;

    private String teamName1;
    private String teamName2;

    //private int record;

    //constructor
    public Game(int id, String player1, String player2, int amount){
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.amount = amount;
    }

    // Setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
}
