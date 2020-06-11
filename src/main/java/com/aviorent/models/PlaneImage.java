package com.aviorent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "planeImage")
public class PlaneImage {

    @GeneratedValue
    @Id
    private long planeImageId;

    @NotBlank(message = "Image path is required.")
    @Column(name = "imagePath")
    private String imagePath;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "planeId")
    private Plane plane;

    public long getPlaneImageId() {
        return planeImageId;
    }

    public void setPlaneImageId(long planeImageId) {
        this.planeImageId = planeImageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
