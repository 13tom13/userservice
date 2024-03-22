package com.tom13.userservice.repository;

import com.tom13.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.isActive = ?2 WHERE u.id = ?1")
    int updateUserIsActive(Long id,Boolean isActive);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.firstName = ?2 WHERE u.id = ?1")
    User updateUserFirstName(Long id,String firstName);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.lastName = ?2 WHERE u.id = ?1")
    int updateUserLastName(Long id,String lastName);

}
