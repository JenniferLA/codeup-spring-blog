package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// entity annotation is what connects the JPA to the
// now we must add a primary key with @Id
@Entity
//under @Entity able to add table annotation
@Table(name = "adlister_ads")
public class Ad {
    // choose Jakarta (Java's db)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //defaults as varchar 255
    @Column(nullable = false, length = 256)
    private String title;

    @Column(nullable = false, length =  1024)
    private String description;

    //add user property
    // many to one relationship
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;


    // adding a two argument constructor to make the example work
    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
