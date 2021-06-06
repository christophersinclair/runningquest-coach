package io.runningquest.coach.repository.impl;

import io.runningquest.coach.model.Quest;
import io.runningquest.coach.repository.QuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestRespositoryImpl implements QuestRepository {

    private static final Logger logger = LoggerFactory.getLogger(QuestRespositoryImpl.class);

    private EntityManager entityManager;

    public QuestRespositoryImpl(EntityManager entityManager) { this.entityManager = entityManager; }

    @Override
    public List<Quest> getQuestListForUserID(Long userID) {
        List<Quest> result = new ArrayList<>();
        try {
            Query q = entityManager.createQuery("SELECT u.quest FROM User u WHERE u.userID = :userID");
            q.setParameter("userID", userID);
            result = q.getResultList();
        } catch (NoResultException ex) {
            logger.error("No quests found in database for user: " + userID);
        }

        return result;
    }
}
