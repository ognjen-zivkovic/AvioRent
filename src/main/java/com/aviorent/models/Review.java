package com.aviorent.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Review {
    @Id
    private int id;
    private int planeId;
    private int userId;
    private String comment;
    private int rating;
}
