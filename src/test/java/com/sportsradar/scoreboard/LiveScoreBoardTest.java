package com.sportsradar.scoreboard;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LiveScoreBoardTest {
    private LiveScoreBoard board;

    /**
     * Setup the board and matches
     */
    @BeforeAll
    public void createScoreBoard() {
        board = new LiveScoreBoard();

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
    }

    @Test
    public void SetMatchScores() {
        
    }
}
