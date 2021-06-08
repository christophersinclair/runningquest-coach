package io.runningquest.coach.controller;

import io.runningquest.coach.model.Trial;
import io.runningquest.coach.service.TrialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrialsController {

    private static final Logger logger = LoggerFactory.getLogger(TrialsController.class);

    @Autowired
    private TrialService trialService;

    @GetMapping("/api/trial/get-for-quest")
    public @ResponseBody ResponseEntity<List<Trial>> getTrialsForQuest(@RequestParam("questid") Long questID) {
        try {
            List<Trial> response = trialService.getForQuest(questID);
            if(response.isEmpty()) {
                logger.error("Could not find trial for quest: " + questID);
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
            logger.info("Found a list of trials for quest: " + questID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Exception occurred while finding trials for quest: " + questID);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error("Parameter is missing from request: " + name);
        return "Parameter is missing from request: '" + name + "'";
    }

}
