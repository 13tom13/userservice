package com.tom13.userservice.repository;


import com.tom13.userservice.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByNameIn(List<String> strings);

    @Query("SELECT r.name FROM Role r")
    List<String> findAllNames();
}
