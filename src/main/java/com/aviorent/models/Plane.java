package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table (name = "plane")
public class Plane {

    @GeneratedValue
    @Id
    private long planeId;

    @NotBlank(message = "Plane model is required")
    @Size(max = 25, message = "Model must not exceed 25 characters")
    @Column (name = "model")
    private String model;

    @NotNull(message = "Number of seats is required")
    @Positive(message = "Value must be positive")
    @Column (name = "seats")
    private int seats;

    @NotNull(message = "Max speed is required")
    @Positive(message = "Max speed value must be positive")
    @Column  (name = "maxSpeed")
    private int maxSpeed;

    @NotNull(message = "Range is required")
    @Positive(message = "Range value must be positive")
    @Column  (name = "range")
    private int range;

    @NotNull(message = "Price is required")
    @Positive(message = "Price value must be positive")
    @Column (name = "price")
    private double price;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<CrewMember> crewMembers;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<Rent> allRents;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<PlaneImage> images;

    public Set<PlaneImage> getImages() {
        return images;
    }

    public void setImages(Set<PlaneImage> images) {
        this.images = images;
    }

    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
