package io.runningquest.coach.repository.impl;

import io.runningquest.coach.exception.CoachException;
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
            Query q = entityManager.createNativeQuery("SELECT uqr.quest_id FROM UserQuestRelation uqr WHERE uqr.user_id = :userID");
            q.setParameter("userID", userID);
            result = q.getResultList();
        } catch (NoResultException ex) {
            logger.error("No quests found in database for user: " + userID);
        }

        return result;
    }

    @Override
    public void addQuestForUserID(Long userID, Long questID) {
        try {
            Query q = entityManager.createNativeQuery("INSERT INTO UserQuestRelation (user_id, quest_id) VALUES (:userID, :questID)");
            q.setParameter("questID", questID);
            q.setParameter("userID", userID);
            int response = q.executeUpdate();
            if (response != 0) {
                throw new CoachException("Update of user " + userID + " with quest " + questID + " has failed.");
            }
        } catch (Exception ex) {
            logger.error("Update of user " + userID + " with quest " + questID + " has failed.");
        }
    }
}
