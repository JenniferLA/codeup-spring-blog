package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "blog_" +
        "posts")

public class Post {

    @Id
    // some circumstances you can use a value of the id itself if it's a unique number like SS numbers
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 75)
    private String title;

    @Column(nullable = false, length = 500)
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
