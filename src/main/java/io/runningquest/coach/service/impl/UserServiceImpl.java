package io.runningquest.coach.service.impl;

import io.runningquest.coach.exception.UserAlreadyExistsException;
import io.runningquest.coach.model.User;
import io.runningquest.coach.repository.UserRepository;
import io.runningquest.coach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerNewUserAccount(User user) throws UserAlreadyExistsException {
        if (emailExists(user.getEmailAddress())) {
            throw new UserAlreadyExistsException("There is already an account with this email address: " + user.getEmailAddress());
        }

        userRepository.registerUser(user);
    }

    private boolean emailExists(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        return true;
    }
}
