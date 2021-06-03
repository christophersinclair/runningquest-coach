package io.runningquest.coach.repository;

import io.runningquest.coach.model.User;

public interface IUserRepository {

    public User findByEmail(String email);

    public void registerUser(User user);
}
