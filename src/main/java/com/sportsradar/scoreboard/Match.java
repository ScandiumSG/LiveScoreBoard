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
        HomeScore = HomeTeamScore;
        AwayScore = AwayTeamScore;
    }

    public ArrayList<Integer> GetMatchScore() {
        ArrayList<Integer> ScoreList = new ArrayList<Integer>();
        ScoreList.add(HomeScore);
        ScoreList.add(AwayScore);

        return ScoreList;
    }

    public String GetMatchName() {
        return HomeTeamName;
    }

}
