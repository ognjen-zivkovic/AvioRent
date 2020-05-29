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
    private int crewMemberId;

    @NotBlank
    @Size(max = 30)
    @Column (name = "firstName")
    private String firstName;

    @NotBlank
    @Size(max = 35)
    @Column (name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn( name = "planeId")
    private Plane plane;

    @ManyToOne
    @JoinColumn( name = "crewMemberTypeId")
    private CrewMemberType crewMemberType;

}
