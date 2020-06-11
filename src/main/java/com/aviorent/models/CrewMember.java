package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "crewMember")
public class CrewMember {
    @GeneratedValue
    @Id
    private long crewMemberId;

    @NotBlank(message = "First name is required.")
    @Size(max = 30, message = " name must not exceed 30 characters.")
    @Column (name = "firstName")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 35, message = "Last name must not exceed 35 characters.")
    @Column (name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn( name = "planeId", nullable = false)
    private Plane plane;


    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public CrewMemberType getCrewMemberType() {
        return crewMemberType;
    }

    public void setCrewMemberType(CrewMemberType crewMemberType) {
        this.crewMemberType = crewMemberType;
    }

    @ManyToOne
    @JoinColumn( name = "crewMemberTypeId", nullable = false)
    private CrewMemberType crewMemberType;

    public long getCrewMemberId() {
        return crewMemberId;
    }

    public void setCrewMemberId(long crewMemberId) {
        this.crewMemberId = crewMemberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
