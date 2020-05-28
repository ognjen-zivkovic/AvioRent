package com.aviorent.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "crewMemberType")
public class CrewMemberType {
    @Id
    private int crewMemberTypeId;
    @Column (name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crewMemberType")
    private Set<CrewMember> crewMembersOfType;

}
