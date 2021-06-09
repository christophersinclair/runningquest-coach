package io.runningquest.coach.service;

import io.runningquest.coach.model.Boss;

import java.util.List;

public interface BossService {

    List<Boss> getForTrial(Long trialID);

}
