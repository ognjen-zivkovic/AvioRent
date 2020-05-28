package com.aviorent.models;


import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    private int reviewId;
    @Column (name = "comment")
    private String comment;
    @Column (name = "rating")
    private int rating;
    @ManyToOne
    private Plane plane;
    @ManyToOne
    private Client madeByClient;

}
