package io.runningquest.coach.repository;

import io.runningquest.coach.exception.CoachException;
import io.runningquest.coach.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class UserRepository implements IUserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByEmail(String email) throws CoachException {
        User result = null;
        try {
            Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.emailAddress = :email");
            q.setParameter("email", email);
            result = (User) q.getSingleResult();
        } catch (NoResultException ex) {
            logger.error("No user found for: " + email);
        }

        return result;
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
