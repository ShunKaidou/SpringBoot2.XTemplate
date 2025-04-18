package com.wecp.w3day5task1.repository;


import com.wecp.w3day5task1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // extends JpaRepository to manage the CRUD operations for the User entity.
}
