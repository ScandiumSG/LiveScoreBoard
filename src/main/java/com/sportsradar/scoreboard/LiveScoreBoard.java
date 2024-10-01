package com.sportsradar.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

public class LiveScoreBoard {
    private HashMap<String, Match> LiveMatches = new HashMap<String, Match>();

    public LiveScoreBoard() {

    }

    public void InitiateMatch(String HomeTeam, String AwayTeam) {
        //TODO: Implement functionality
    }

    public Match GetMatchByHomeTeamName(String HomeTeamName) {
        //TODO: Implement functionality

        return null;
    }

    public ArrayList<Match> GetScores() {
        ArrayList<Match> Scores = new ArrayList<Match>();
        //TODO: Implement functionality
        
        return Scores;
    }

    public void CloseMatch(String HomeTeamName) {   
        //TODO: Implement functionality
    }
}
