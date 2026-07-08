package com.cognizant.mockitospring;

import com.cognizant.mockitospring.model.User;
import com.cognizant.mockitospring.repository.UserRepository;
import com.cognizant.mockitospring.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void testServiceWithMockRepositoryDependency() {
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "Anita")));

        UserService userService = new UserService(userRepository);

        User result = userService.getUserById(1L);

        assertEquals("Anita", result.getName());
        verify(userRepository).findById(1L);
    }
}
