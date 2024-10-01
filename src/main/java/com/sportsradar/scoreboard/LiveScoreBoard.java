package com.sportsradar.scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class LiveScoreBoard {
    private LinkedHashMap<String, Match> LiveMatches = new LinkedHashMap<String, Match>();

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
        Scores.addAll(LiveMatches.values());

        // Make the list sorted based on time added/initalized
        Collections.reverse(Scores);
        
        // Sort the list
        SortMatchesByScore(Scores);

        return Scores;
    }

    /**
     * Sort a ArrayList of Match objects by the combined score of the Home and Away teams. Uses inplace-sorting.
     * @param ActiveMatches The ArrayList of Match objects to sort.
     */
    private void SortMatchesByScore(ArrayList<Match> ActiveMatches) {
        ActiveMatches.sort((m1, m2) -> 
            (m2.GetMatchScore().get(0) + m2.GetMatchScore().get(1))
            -
            (m1.GetMatchScore().get(0) + m1.GetMatchScore().get(1))
        );
    }

    public void CloseMatch(String HomeTeamName) {   
        this.LiveMatches.remove(HomeTeamName);
    }
}
