package com.sportsradar.scoreboard;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LiveScoreBoardTest {
    private LiveScoreBoard board;

    /**
     * Setup the board, matches, and scores.
     */
    @BeforeEach
    public void CreateScoreBoard() {
        this.board = new LiveScoreBoard();

        assertTrue(this.board.GetScores().size() == 0);

        this.board.InitiateMatch("Mexico", "Canada");
        assertTrue(this.board.GetScores().size() == 1);

        this.board.InitiateMatch("Spain", "Brazil");
        assertTrue(this.board.GetScores().size() == 2);

        this.board.InitiateMatch("Germany", "France");
        assertTrue(this.board.GetScores().size() == 3);

        this.board.InitiateMatch("Uruguay", "Italy");
        assertTrue(this.board.GetScores().size() == 4);

        this.board.InitiateMatch("Argentina", "Australia");
        assertTrue(this.board.GetScores().size() == 5);

        // Ensure all matches initalize to 0-0
        assertTrue(this.board.GetScores().stream().allMatch(
            m -> 
            m.GetMatchScore().get(0) == 0 && 
            m.GetMatchScore().get(1) == 0
            )
        );

        this.board.GetMatchByHomeTeamName("Mexico").UpdateScore(0,5);
        this.board.GetMatchByHomeTeamName("Spain").UpdateScore(10,2);
        this.board.GetMatchByHomeTeamName("Germany").UpdateScore(2,2);
        this.board.GetMatchByHomeTeamName("Uruguay").UpdateScore(6,6);
        this.board.GetMatchByHomeTeamName("Argentina").UpdateScore(3,1);
    }

    /**
     * Test that proper scores were set in the BeforeEach setup phase
     */
    @Test
    public void TestMatchScoresSet() {
        // Match a, MEX-CAN
        assertTrue(this.board.GetMatchByHomeTeamName("Mexico").GetMatchScore().get(0) == 0);
        assertTrue(this.board.GetMatchByHomeTeamName("Mexico").GetMatchScore().get(1) == 5);
        
        // Match b, SPA-BRA
        assertTrue(this.board.GetMatchByHomeTeamName("Spain").GetMatchScore().get(0) == 10);
        assertTrue(this.board.GetMatchByHomeTeamName("Spain").GetMatchScore().get(1) == 2);

        // Match c, GER-FRA
        assertTrue(this.board.GetMatchByHomeTeamName("Germany").GetMatchScore().get(0) == 2);
        assertTrue(this.board.GetMatchByHomeTeamName("Germany").GetMatchScore().get(1) == 2);

        // Match d, URU - ITA
        assertTrue(this.board.GetMatchByHomeTeamName("Uruguay").GetMatchScore().get(0) == 6);
        assertTrue(this.board.GetMatchByHomeTeamName("Uruguay").GetMatchScore().get(1) == 6);

        // Match e, ARG-AUS
        assertTrue(this.board.GetMatchByHomeTeamName("Argentina").GetMatchScore().get(0) == 3);
        assertTrue(this.board.GetMatchByHomeTeamName("Argentina").GetMatchScore().get(1) == 1);
    }

    /** 
     * Check score, then set to ensure it changes properly. 
     */
    @Test
    public void TestSetMatchScores() {
        String MatchName = "Spain";
        assertTrue(this.board.GetMatchByHomeTeamName(MatchName).GetMatchScore().get(0) == 10);
        assertTrue(this.board.GetMatchByHomeTeamName(MatchName).GetMatchScore().get(1) == 2);

        this.board.GetMatchByHomeTeamName(MatchName).UpdateScore(22,2);

        assertTrue(this.board.GetMatchByHomeTeamName(MatchName).GetMatchScore().get(0) == 22);
        assertTrue(this.board.GetMatchByHomeTeamName(MatchName).GetMatchScore().get(1) == 2);
    }

    /**
     * Try to finish match and ensure its removed from the scoreboard
     */
    @Test
    public void TestFinishMatch() {
        Random rng = new Random();
        Integer MatchesToRemove = rng.nextInt(5);
        Integer TotalMatches = this.board.GetScores().size() - MatchesToRemove;


        for (int i = 0; i < MatchesToRemove; i++) {
            ArrayList<Match> Matches = this.board.GetScores();
            Integer MatchesOnScoreBoard = Matches.size();
            this.board.CloseMatch(Matches.get(rng.nextInt(MatchesOnScoreBoard)).GetMatchName());
        }

        assertTrue(this.board.GetScores().size() == TotalMatches);
    }
    
    /**
     * Check that the ordering of the GetScores() method properly sorts by total match score.
     */
    @Test
    public void TestScoreBoardOrder() {
        ArrayList<Match> Matches = this.board.GetScores();

        assertTrue(Matches.get(0).GetMatchName() == "Uruguay");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 6);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 6);

        assertTrue(Matches.get(0).GetMatchName() == "Spain");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 10);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 2);

        assertTrue(Matches.get(0).GetMatchName() == "Mexico");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 0);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 5);

        assertTrue(Matches.get(0).GetMatchName() == "Argentina");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 3);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 1);

        assertTrue(Matches.get(0).GetMatchName() == "Germany");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 6);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 6);

        assertTrue(Matches.get(0).GetMatchName() == "Uruguay");
        assertTrue(Matches.get(0).GetMatchScore().get(0) == 6);
        assertTrue(Matches.get(0).GetMatchScore().get(1) == 6);
    }
}
