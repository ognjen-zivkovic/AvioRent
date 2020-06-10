package com.aviorent.dtos;

import com.aviorent.models.PlaneImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PlaneWithImagesDto {

    private long planeId;

    private String model;

    private int seats;

    private int maxSpeed;

    private int range;

    private double price;

    List<PlaneImage> images;

    private boolean currentlyRented;

    public boolean isCurrentlyRented() {
        return currentlyRented;
    }

    public void setCurrentlyRented(boolean currentlyRented) {
        this.currentlyRented = currentlyRented;
    }

    public List<PlaneImage> getImages() {
        return images;
    }

    public void setImages(List<PlaneImage> images) {
        this.images = images;
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

    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }
}
