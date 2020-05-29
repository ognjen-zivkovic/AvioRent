package com.aviorent.models;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Review {
    @GeneratedValue
    @Id
    private int reviewId;


    @Size(max = 255, message = "Comment size is not valid")
    @Column (name = "comment")
    private String comment;

    @NotNull(message = "Rating is required")
    @Size(min = 1, max = 5)
    @Column (name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client madeByClient;

}
