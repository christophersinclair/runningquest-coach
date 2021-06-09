package io.runningquest.coach.service.impl;

import io.runningquest.coach.model.Boss;
import io.runningquest.coach.repository.BossRepository;
import io.runningquest.coach.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossServiceImpl implements BossService {

    @Autowired
    private BossRepository bossRepository;

    @Override
    public List<Boss> getForTrial(Long trialID) {
        return bossRepository.getBossForTrialID(trialID);
    }
}
