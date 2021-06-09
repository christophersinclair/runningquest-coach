package io.runningquest.coach.repository;

import io.runningquest.coach.model.Boss;

import java.util.List;

public interface BossRepository {

    List<Boss> getBossForTrialID(Long trialID);
}
