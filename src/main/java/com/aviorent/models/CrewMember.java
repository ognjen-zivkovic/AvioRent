package com.aviorent.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CrewMember {
    @Id
    private int crewMemberId;
    private String firstName;
    private String lastName;
}
