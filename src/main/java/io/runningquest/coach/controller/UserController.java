package io.runningquest.coach.controller;

import io.runningquest.coach.exception.UserAlreadyExistsException;
import io.runningquest.coach.model.User;
import io.runningquest.coach.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @PostMapping("/user/register")
    public @ResponseBody ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);


            iUserService.registerNewUserAccount(user);
            logger.info("Registered user: " + user.getEmailAddress());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            logger.error("User already exists: " + user.getEmailAddress());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error("Parameter is missing from request: " + name);
        return "Parameter is missing from request: '" + name + "'";
    }
}
