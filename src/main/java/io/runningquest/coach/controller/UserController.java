package io.runningquest.coach.controller;

import io.runningquest.coach.exception.UserAlreadyExistsException;
import io.runningquest.coach.model.User;
import io.runningquest.coach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/register")
    public @ResponseBody ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);


            userService.registerNewUserAccount(user);
            logger.info("Registered user: " + user.getEmailAddress());
            return new ResponseEntity<>("User " + user.getEmailAddress() + " registered.", HttpStatus.CREATED);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            logger.error("User already exists: " + user.getEmailAddress());
            return new ResponseEntity<>("User with email address: " + user.getEmailAddress() + " already exists.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error("Parameter is missing from request: " + name);
        return "Parameter is missing from request: '" + name + "'";
    }
}
