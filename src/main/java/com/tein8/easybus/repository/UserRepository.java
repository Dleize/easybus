package com.tein8.easybus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tein8.easybus.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findByEmail(String email);

}
