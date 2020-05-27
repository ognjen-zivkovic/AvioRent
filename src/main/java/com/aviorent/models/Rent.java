package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rent")
public class Rent {
    @Id
    private int rentId;
    @Column(name = "dateStart")
    private Date dateStart;
    @Column(name = "dateEnd")
    private Date dateEnd;
    @Column
    private double price;
    @Column
    private Date createdAt;
    @Column
    private int passengers;
    @ManyToOne
    @JoinColumn(name = "rents")
    private RentStatus rentStatus;

}
