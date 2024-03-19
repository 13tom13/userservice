package com.tom13.userservice.repository;

import com.tom13.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User deleteUserByEmail(String email);
}
