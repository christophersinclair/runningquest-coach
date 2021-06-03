package io.runningquest.coach.repository;

import io.runningquest.coach.exception.CoachException;
import io.runningquest.coach.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class UserRepository implements IUserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private EntityManager entityManager;

    @Override
    public User findByEmail(String email) throws CoachException {
        try {
            return entityManager.find(User.class, email);
        } catch (Exception ex) {
            logger.error("An exception occurred while retrieving a user by their email: " + ex.getMessage());
            throw new CoachException(ex.getMessage());
        }
    }

    @Transactional
    @Override
    public void registerUser(User user) throws CoachException {
        try {
            entityManager.persist(user);
        } catch (Exception ex) {
            logger.error("An exception occurred while saving user details to database: " + ex.getMessage());
            throw new CoachException(ex.getMessage());
        }
    }
}
