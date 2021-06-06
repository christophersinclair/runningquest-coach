package io.runningquest.coach.service;

import io.runningquest.coach.model.Trial;

import java.util.List;

public interface TrialService {

    List<Trial> getForQuest(Long questID);
}
