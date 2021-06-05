package io.runningquest.coach.repository;

import io.runningquest.coach.model.User;

public interface UserRepository {

    public User findByEmail(String email);

    public void registerUser(User user);
}
