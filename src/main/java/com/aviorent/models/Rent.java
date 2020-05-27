package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Rent {
    @Id
    private int rentId;
    private Date dateStart;
    private Date dateEnd;
    private double price;
    private Date createdAt;
    private int passengers;
    @ManyToOne
    private RentStatus rentStatus;

}
