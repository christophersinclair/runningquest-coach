package io.runningquest.coach.repository.impl;

import io.runningquest.coach.model.Trial;
import io.runningquest.coach.repository.TrialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrialRepositoryImpl implements TrialRepository {

    private static final Logger logger = LoggerFactory.getLogger(TrialRepositoryImpl.class);

    private EntityManager entityManager;

    public TrialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Trial> getTrialListForQuestID(Long questID) {
        List<Trial> result = new ArrayList<>();
        try {
            Query q = entityManager.createQuery("SELECT q.trial FROM Quest q WHERE q.questID = :questID");
            q.setParameter("questID", questID);
            result = q.getResultList();
        } catch (NoResultException ex) {
            logger.error("No trials found in database for quest: " + questID);
        }
    }
}
