package org.sk.modal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {
    private Match match;

    @BeforeEach
    public void setUp() {
        match = new Match("HomeTeam", "AwayTeam");
    }

    @Test
    public void testUpdateAndTotalScore() {
        int homeScore = 2;
        int awayScore = 3;

        match.updateScore(homeScore, awayScore);

        int expectedTotalScore = homeScore + awayScore;
        assertEquals(expectedTotalScore, match.getTotalScore());
    }

    @Test
    public void testWithoutUpdate() {
        int expectedTotalScore = 0;
        assertEquals(expectedTotalScore, match.getTotalScore());
    }
}