package com.cognizant.springtest;

import com.cognizant.springtest.model.User;
import com.cognizant.springtest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCustomRepositoryQueryFindByName() {
        userRepository.save(new User(1L, "John"));
        userRepository.save(new User(2L, "John"));
        userRepository.save(new User(3L, "Anita"));

        List<User> users = userRepository.findByName("John");

        assertEquals(2, users.size());
    }
}
