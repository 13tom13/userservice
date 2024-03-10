package com.tom13.userservice.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {
private List<Role> roleList;
}
