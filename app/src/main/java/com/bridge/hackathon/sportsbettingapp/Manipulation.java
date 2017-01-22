package com.bridge.hackathon.sportsbettingapp;

import java.util.ArrayList;

/**
 * Created by kyleohanian on 1/21/17.
 */

public class Manipulation extends Variables {
    public void addParticipant (String email, int bet) {
        participants.put(email, bet);
        emails.add(email);
        pair(email, bet);
    }

    public void pair (String email, int bet) {
        if (participants.size() >= 2) {
            int finalBet = 0;
            int betPlayer1 = participants.get(emails.get(0));
            int betPlayer2 = participants.get(emails.get(1));

            if (betPlayer1 <= betPlayer2) {
                finalBet = betPlayer1;
            } else {
                finalBet = betPlayer2;
            }

            while (true) {
                try {
                    bets.get(finalBet);
                    finalBet++;
                } catch (Exception e) {
                    break;
                }
            }

            bets.put(finalBet, new ArrayList<String>());
            bets.get(finalBet).add(emails.get(0));
            bets.get(finalBet).add(emails.get(1));
            emails.remove(0);
            emails.remove(0);
            participants.remove(0);
            participants.remove(0);
        }
    }
}
