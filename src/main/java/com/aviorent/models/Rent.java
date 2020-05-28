package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    private int rentId;
    @Column(name = "dateStart")
    private Date dateStart;
    @Column(name = "dateEnd")
    private Date dateEnd;
    @Column (name = "price")
    private double price;
    @Column  (name = "createdAt")
    private Date createdAt;
    @Column (name = "passengers")
    private int passengers;
    @ManyToOne
    @JoinColumn(name = "rentStatusId")
    private RentStatus rentStatus;
    /*@ManyToOne
    private RentStatus rentStatus;*/

    @ManyToOne
    private Client client;

}
