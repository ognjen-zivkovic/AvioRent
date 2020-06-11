package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {
    @GeneratedValue
    @Id
    private long rentId;

    @Column(name = "dateStart")
    private Date dateStart;

    @Column(name = "dateEnd")
    private Date dateEnd;

    @Column  (name = "createdAt")
    private Date createdAt;

    @NotNull(message = "Number of passengers is not valid")
    @Positive(message = "Passengers value must be positive")
    @Column (name = "passengers")
    private int passengers;

    @NotBlank(message = "Star destination is required")
    @Column (name = "destinationFrom")
    private String destinationFrom;

    @NotBlank(message = "End destination is required")
    @Column (name = "destinationTo")
    private String destinationTo;


    @Column (name = "isRoundTrip")
    private boolean isRoundTrip;

    @ManyToOne
    @JoinColumn(name = "rentStatusId")
    private RentStatus rentStatus;


    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane plane;

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) throws ParseException {
        this.dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public String getDestinationTo() {
        return destinationTo;
    }

    public void setDestinationTo(String destinationTo) {
        this.destinationTo = destinationTo;
    }

    public boolean isRoundTrip() {
        return isRoundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        isRoundTrip = roundTrip;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
