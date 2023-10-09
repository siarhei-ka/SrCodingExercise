package org.sk.exception;

public class MatchNotFoundException extends Exception {

    public MatchNotFoundException() {
        this("Match not found!");
    }

    public MatchNotFoundException(String message) {
        super(message);
    }
}
