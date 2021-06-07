package io.runningquest.coach.service;

import io.runningquest.coach.model.Quest;

import java.util.List;

public interface QuestService {

    List<Quest> getForUser(Long userID);

    void addForUser(Long userID, Long questID);

}
