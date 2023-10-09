package org.sk.storage;

import org.sk.modal.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ScoreBoardStorage {

    private List<Match> matches = new ArrayList<>();
    private static final ScoreBoardStorage instance = new ScoreBoardStorage();

    private ScoreBoardStorage(){}

    public static ScoreBoardStorage getInstance(){
        return instance;
    }

    public Optional<Match> get(final String homeTeam, final String awayTeam){
        return matches.stream()
                      .filter(getMatchPredicate(homeTeam, awayTeam))
                      .findFirst();
    }

    public List<Match> getAll() {
        return Collections.unmodifiableList(matches);
    }

    public void add(Match match) {
        matches.add(match);
    }

    private static Predicate<Match> getMatchPredicate(String homeTeam, String awayTeam) {
        return m -> homeTeam.equals(m.getHomeTeam())
                && awayTeam.equals(m.getAwayTeam());
    }

    public void remove(Match match) {
        matches.remove(match);
    }
}
