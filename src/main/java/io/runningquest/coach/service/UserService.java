package io.runningquest.coach.service;

import io.runningquest.coach.exception.UserAlreadyExistsException;
import io.runningquest.coach.model.User;
import io.runningquest.coach.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void registerNewUserAccount(User user) throws UserAlreadyExistsException {
        if (emailExists(user.getEmailAddress())) {
            throw new UserAlreadyExistsException("There is already an account with this email address: " + user.getEmailAddress());
        }

        iUserRepository.registerUser(user);
    }

    private boolean emailExists(String email) {
        return iUserRepository.findByEmail(email) != null;
    }
}
