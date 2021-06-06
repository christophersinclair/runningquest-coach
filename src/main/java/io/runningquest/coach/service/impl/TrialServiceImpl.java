package io.runningquest.coach.service.impl;

import io.runningquest.coach.model.Trial;
import io.runningquest.coach.repository.TrialRepository;
import io.runningquest.coach.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrialServiceImpl implements TrialService {

    @Autowired
    private TrialRepository trialRepository;

    @Override
    public List<Trial> getForQuest(Long questID) {
        return trialRepository.getTrialListForQuestID(questID);
    }
}
