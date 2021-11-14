package com.springBootExamples.flyway.repository;

import com.springBootExamples.flyway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
