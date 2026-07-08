package com.cognizant.mockitospring.repository;

import com.cognizant.mockitospring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
