package com.tom13.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user_role")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Role implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    @NotEmpty
    private final String name;
}
