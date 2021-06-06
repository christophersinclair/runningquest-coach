package io.runningquest.coach.repository;

import io.runningquest.coach.model.Quest;

import java.util.List;

public interface QuestRepository {

    List<Quest> getQuestListForUserID(Long userID);
}
