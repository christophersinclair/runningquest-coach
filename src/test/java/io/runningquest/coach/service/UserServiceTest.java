package io.runningquest.coach.service;

import io.runningquest.coach.exception.UserAlreadyExistsException;
import io.runningquest.coach.model.User;
import io.runningquest.coach.repository.IUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
