package com.aviorent.models;

import javax.persistence.*;

@Entity
@Table (name = "crewMember")
public class CrewMember {
    @Id
    private int crewMemberId;
    @Column (name = "firstName")
    private String firstName;
    @Column (name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn( name = "planeId")
    private Plane plane;

    @ManyToOne
    @JoinColumn( name = "crewMemberTypeId")
    private CrewMemberType crewMemberType;

}
