package org.sk.scoreboard;

import org.sk.exception.MatchNotFoundException;
import org.sk.exception.UpdateScoreException;
import org.sk.exception.StartMatchException;
import org.sk.modal.Match;

import java.util.List;

public interface IScoreBoard {

    void startNewMatch(String homeTeam, String awayTeam) throws StartMatchException;
    void finishMatch(String homeTeam, String awayTeam) throws MatchNotFoundException;
    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) throws UpdateScoreException, MatchNotFoundException;
    List<Match> getMatchesInProgressOrderedByTotalScore();

}
