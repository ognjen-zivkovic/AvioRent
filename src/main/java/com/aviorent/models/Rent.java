package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Rent {
    @Id
    private int id;
    private int userId;
    private int planeId;
    private Date dateStart;
    private Date dateEnd;
    private double price;
    private Date createdAt;
    private int rentStatusId;
    private int passengers;

}
