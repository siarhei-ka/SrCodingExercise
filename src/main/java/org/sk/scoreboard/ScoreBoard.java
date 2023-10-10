package org.sk.scoreboard;

import org.sk.football.FootBallScoreBoard;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ScoreBoard implements IScoreBoard {

    private static String DEFAULT = FootBallScoreBoard.class.getName();
    private static final ConcurrentMap<String, ScoreBoard> cache = new ConcurrentHashMap<>();
    private static ScoreBoard scoreBoard;
    public static ScoreBoard getInstance() {
        return createScoreBoard();
    }

    private static ScoreBoard createScoreBoard() {
        if ((scoreBoard = cache.get(DEFAULT)) != null) {
            return scoreBoard;
        } else {
            scoreBoard = new FootBallScoreBoard();
            cache.put(DEFAULT, scoreBoard);
            return scoreBoard;
        }
    }
}
