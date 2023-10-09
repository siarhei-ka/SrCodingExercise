package org.sk.modal;

import java.util.Objects;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeTeamScore = homeScore;
        this.awayTeamScore = awayScore;
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }
    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String toString() {
        return homeTeam + " : " + awayTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Match match = (Match) o;
        return Objects.equals(homeTeam, match.homeTeam) && Objects.equals(
                awayTeam, match.awayTeam);
    }
}
