package io.runningquest.coach.exception;

public class UserAlreadyExistsException extends CoachException {
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(String message, Throwable t) { super(message, t); }

    public UserAlreadyExistsException(String message) { super(message); }
}
