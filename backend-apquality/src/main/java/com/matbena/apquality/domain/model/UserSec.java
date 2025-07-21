package com.matbena.apquality.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class UserSec {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
