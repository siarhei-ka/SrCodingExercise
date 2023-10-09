package org.sk.exception;

public class UpdateScoreException extends ScoreException {
    public UpdateScoreException() {
        this("Error during updating Score");
    }

    public UpdateScoreException(String message) {
        super(message);
    }
}
