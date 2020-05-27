package com.aviorent.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CrewMemberType {
    @Id
    private int crewMemberTypeId;
    private String type;
}
