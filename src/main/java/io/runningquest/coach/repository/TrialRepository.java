package io.runningquest.coach.repository;

import io.runningquest.coach.model.Trial;

import java.util.List;

public interface TrialRepository {

    List<Trial> getTrialListForQuestID(Long questID);
}
