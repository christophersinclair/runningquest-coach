package io.runningquest.coach.repository.impl;

import io.runningquest.coach.model.Boss;
import io.runningquest.coach.repository.BossRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BossRepositoryImpl implements BossRepository {

    private static final Logger logger = LoggerFactory.getLogger(BossRepositoryImpl.class);

    private EntityManager entityManager;

    public BossRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Boss> getBossForTrialID(Long trialID) {
        List<Boss> result = new ArrayList<>();
        try {
            Query q = entityManager.createNativeQuery("SELECT * FROM Boss WHERE id IN (SELECT tbr.boss_id FROM TrialBossRelation tbr WHERE tbr.trial_id = :trialID)");
            q.setParameter("trialID", trialID);
            result = q.getResultList();
        } catch (NoResultException ex) {
            logger.error("No boss found in database for trial: " + trialID);
        }
        return result;
    }
}
