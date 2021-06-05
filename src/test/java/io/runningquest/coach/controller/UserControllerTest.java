package io.runningquest.coach.controller;

import io.runningquest.coach.model.User;
import io.runningquest.coach.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userControllerTest;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserRegistration() {
        User user = new User();
        user.setEmailAddress("blahblah@runningquest.io");
        // iUserService.registerNewUserAccount(user);

    }
}
