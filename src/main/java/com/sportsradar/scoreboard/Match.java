package com.sportsradar.scoreboard;

import java.util.ArrayList;

public class Match {

    private String HomeTeamName;
    private String AwayTeamName;

    private Integer HomeScore = 0;
    private Integer AwayScore = 0;

    public Match(String HomeTeam, String AwayTeam) {
        HomeTeamName = HomeTeam;
        AwayTeamName = AwayTeam;
    }

    public void UpdateScore(Integer HomeTeamScore, Integer AwayTeamScore) {
        //TODO: Implement this functionality
    }

    public ArrayList<Integer> GetMatchScore() {
        //TODO: Implement this functionality
        return null;
    }

    public String GetMatchName() {
        //TODO: Implement this functionality
        return null;
    }

}
