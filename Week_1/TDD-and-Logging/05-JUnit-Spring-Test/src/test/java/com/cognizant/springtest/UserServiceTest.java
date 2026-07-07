package com.cognizant.springtest;

import com.cognizant.springtest.model.User;
import com.cognizant.springtest.repository.UserRepository;
import com.cognizant.springtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Test
    public void testGetUserByIdWithMockRepository() {
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "John")));

        UserService userService = new UserService(userRepository);

        User result = userService.getUserById(1L);

        assertEquals("John", result.getName());
    }

    @Test
    public void testServiceExceptionHandlingForMissingUser() {
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        UserService userService = new UserService(userRepository);

        assertThrows(NoSuchElementException.class, () -> userService.getUserById(99L));
    }
}
