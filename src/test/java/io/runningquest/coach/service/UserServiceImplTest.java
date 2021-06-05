package io.runningquest.coach.service;

import io.runningquest.coach.repository.UserRepository;
import io.runningquest.coach.service.impl.UserServiceImpl;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
