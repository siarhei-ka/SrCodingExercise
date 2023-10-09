package org.sk.scoreboard;

import org.sk.football.FootBallScoreBoard;

public abstract class ScoreBoard implements IScoreBoard {

    public static ScoreBoard getInstance() {
        return createScoreBoard();
    }

    private static ScoreBoard createScoreBoard() {
        return new FootBallScoreBoard();
    }
}
