package com.aviorent.models;

import javax.persistence.*;

@Entity
@Table (name = "CrewMember")
public class CrewMember {
    @Id
    private int crewMemberId;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "crewMembers")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "crewMembers")
    private CrewMemberType crewMemberType;

}
