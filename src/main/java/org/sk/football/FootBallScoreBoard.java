package org.sk.football;

import org.sk.exception.MatchNotFoundException;
import org.sk.exception.StartMatchException;
import org.sk.exception.UpdateScoreException;
import org.sk.modal.Match;
import org.sk.scoreboard.ScoreBoard;
import org.sk.storage.ScoreBoardStorage;

import java.util.*;

public final class FootBallScoreBoard extends ScoreBoard {


    private ScoreBoardStorage scoreBoardStorage = ScoreBoardStorage.getInstance();
    public FootBallScoreBoard() {}

    public void startNewMatch(String homeTeam, String awayTeam) throws StartMatchException {
        Match match = scoreBoardStorage.get(homeTeam, awayTeam).get();
        if (match != null) {
            throw new StartMatchException("Match has already started");
        }
        scoreBoardStorage.add(match);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) throws UpdateScoreException, MatchNotFoundException {
        Match match = scoreBoardStorage.get(homeTeam, awayTeam)
                                       .orElseThrow(MatchNotFoundException::new);

        validate(match, homeScore, awayScore);
        match.updateScore(homeScore, awayScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) throws MatchNotFoundException {
        Match match = scoreBoardStorage.get(homeTeam, awayTeam)
                                       .orElseThrow(MatchNotFoundException::new);
        scoreBoardStorage.remove(match);
    }

    public List<Match> getMatchesInProgressOrderedByTotalScore() {
        List<Match> matchesCopy = new ArrayList<>(scoreBoardStorage.getAll());
        Collections.sort(matchesCopy, Comparator.comparingInt(Match::getTotalScore).reversed()
                                                .thenComparing(Comparator.comparingInt(scoreBoardStorage.getAll()::indexOf)));
        return matchesCopy;
    }



    private void validate (Match match, int homeScore, int awayScore) throws UpdateScoreException {
        if ((match.getTotalScore() + 1) != (homeScore + awayScore) ||
                homeScore < 0 ||
                awayScore < 0 ||
                match.getHomeTeamScore() > homeScore ||
                match.getAwayTeamScore() > awayScore) {
            throw new UpdateScoreException();
        }
    }
}
