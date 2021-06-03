package io.runningquest.coach.exception;

public class CoachException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CoachException(String message, Throwable t) { super(message, t); }

    public CoachException(String message) { super(message); }
}
