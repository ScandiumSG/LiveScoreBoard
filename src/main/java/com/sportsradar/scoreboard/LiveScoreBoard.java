package com.sportsradar.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

public class LiveScoreBoard {
    private HashMap<String, Match> LiveMatches = new HashMap<String, Match>();

    public LiveScoreBoard() {

    }

    public void InitiateMatch(String HomeTeam, String AwayTeam) {
        Match newMatch = new Match(HomeTeam, AwayTeam);
        this.LiveMatches.put(HomeTeam, newMatch);
    }

    public Match GetMatchByHomeTeamName(String HomeTeamName) {
        return this.LiveMatches.get(HomeTeamName);
    }

    public ArrayList<Match> GetScores() {
        ArrayList<Match> Scores = new ArrayList<Match>();
        //TODO: Implement functionality


        return Scores;
    }

    public void CloseMatch(String HomeTeamName) {   
        this.LiveMatches.remove(HomeTeamName);
    }
}
