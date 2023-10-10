package org.sk.football;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sk.exception.MatchNotFoundException;
import org.sk.exception.StartMatchException;
import org.sk.exception.UpdateScoreException;
import org.sk.modal.Match;
import org.sk.scoreboard.IScoreBoard;
import org.sk.scoreboard.ScoreBoard;
import org.sk.storage.ScoreBoardStorage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FootBallScoreBoardTest {

    private IScoreBoard footBallScoreBoard;
    private ScoreBoardStorage scoreBoardStorage;

    @BeforeEach
    public void setUp() {
        footBallScoreBoard = ScoreBoard.getInstance();
        scoreBoardStorage = ScoreBoardStorage.getInstance();
    }

    @Test
    public void testStartNewMatchWhenMatchAlreadyStartedThenThrowStartMatchException() {
        Match match = new Match("Team1", "Team2");
        scoreBoardStorage.add(match);

        assertThrows(StartMatchException.class, () -> footBallScoreBoard.startNewMatch("Team1", "Team2"));
    }

    @Test
    public void testUpdateScoreWhenScoresNotValidThenThrowUpdateScoreException() {
        Match match = new Match("Team1", "Team2");
        scoreBoardStorage.add(match);

        assertThrows(UpdateScoreException.class, () -> footBallScoreBoard.updateScore("Team1", "Team2", -1, -1));
    }

    @Test
    public void testFinishMatchWhenMatchFoundThenRemoveMatchFromStorage() throws MatchNotFoundException {
        Match match = new Match("Team10", "Team20");
        scoreBoardStorage.add(match);

        footBallScoreBoard.finishMatch("Team10", "Team20");

        assertFalse(scoreBoardStorage.getAll().contains(match));
    }

    @Test
    public void testGetMatchesInProgressOrderedByTotalScoreThenReturnMatchesInDescendingOrder() {
        Match match1 = new Match("Team11", "Team12");
        match1.updateScore(1, 0);
        Match match2 = new Match("Team13", "Team14");
        match2.updateScore(2, 0);
        Match match3 = new Match("Team15", "Team16");
        match3.updateScore(3, 0);

        scoreBoardStorage.add(match1);
        scoreBoardStorage.add(match2);
        scoreBoardStorage.add(match3);

        List<Match> matches = footBallScoreBoard.getMatchesInProgressOrderedByTotalScore();

        assertEquals(match3, matches.get(0));
        assertEquals(match2, matches.get(1));
        assertEquals(match1, matches.get(2));
    }
}