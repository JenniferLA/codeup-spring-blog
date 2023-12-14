package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// bc we want a user table in the database
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 70)
    // if you don't specify false then it will default to allow null
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    // no limit on password bc using hashpassword
    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Ad> ads;

}
