package io.runningquest.coach.controller;

import io.runningquest.coach.model.Quest;
import io.runningquest.coach.service.QuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestController {

    private static final Logger logger = LoggerFactory.getLogger(QuestController.class);

    @Autowired
    QuestService questService;

    @GetMapping("/api/quest/get-for-user")
    public @ResponseBody ResponseEntity<List<Quest>> getQuestForUser(@RequestParam("userid") Long userID) {
        try {
            List<Quest> response = questService.getForUser(userID);
            if (response.isEmpty()) {
                logger.error("Could not find quest for user: " + userID);
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
            logger.info("Found a list of quests for user: " + userID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Exception occurred while finding quests for user: " + userID);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/quest/add-quest-for-user")
    public @ResponseBody ResponseEntity<String> addQuestForUser(@RequestParam("userid") Long userID, @RequestParam("questid") Long questID) {
        try {
            questService.addForUser(userID, questID);
            logger.info("Added quest " + questID + " for user " + userID);
            return new ResponseEntity<>("Added quest " + questID + " for user " + userID, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Exception occurred while adding quest " + questID + " for user " + userID);
            return new ResponseEntity<>("Could not add quest " + questID + " for user " + userID, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error("Parameter is missing from request: " + name);
        return "Parameter is missing from request: '" + name + "'";
    }

}
