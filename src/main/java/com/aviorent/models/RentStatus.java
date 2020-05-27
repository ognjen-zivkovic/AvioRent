package com.aviorent.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RentStatus {
    @Id
    private int id;
    private String status;

}
