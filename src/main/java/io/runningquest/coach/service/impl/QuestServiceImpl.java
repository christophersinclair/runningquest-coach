package io.runningquest.coach.service.impl;

import io.runningquest.coach.model.Quest;
import io.runningquest.coach.repository.QuestRepository;
import io.runningquest.coach.service.QuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private static final Logger logger = LoggerFactory.getLogger(QuestServiceImpl.class);

    @Autowired
    private QuestRepository questRepository;

    @Override
    public List<Quest> getForUser(Long userID) {
        return questRepository.getQuestListForUserID(userID);
    }

    @Override
    public void addForUser(Long userID, Long questID) {
        questRepository.addQuestForUserID(userID, questID);
    }
}
