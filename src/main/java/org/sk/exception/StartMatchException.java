package org.sk.exception;

public class StartMatchException extends ScoreException {

    public StartMatchException() {
        this("Match has already started");
    }
    public StartMatchException(String message) {
        super(message);
    }
}
