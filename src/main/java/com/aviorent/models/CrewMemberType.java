package com.aviorent.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "CrewMemberType")
public class CrewMemberType {
    @Id
    private int crewMemberTypeId;
    @Column
    private String type;

    @OneToMany(mappedBy = "crewMemberType")
    private Set<CrewMember> crewMembers;

}
