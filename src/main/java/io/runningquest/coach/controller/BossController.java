package io.runningquest.coach.controller;

import io.runningquest.coach.model.Boss;
import io.runningquest.coach.service.BossService;
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
public class BossController {

    private static final Logger logger = LoggerFactory.getLogger(BossController.class);

    @Autowired
    private BossService bossService;

    @GetMapping("/api/boss/get-for-trial")
    public @ResponseBody
    ResponseEntity<List<Boss>> getBossForTrial(@RequestParam("trialid") Long trialID) {
        try {
            List<Boss> response = bossService.getForTrial(trialID);
            if(response.isEmpty()) {
                logger.error("Could not find boss for trial: " + trialID);
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
            logger.info("Found a boss for trial: " + trialID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Exception occurred while finding boss for trial: " + trialID + ". " + ex.getMessage());
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
