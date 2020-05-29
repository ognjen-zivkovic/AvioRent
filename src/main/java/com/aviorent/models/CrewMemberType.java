package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table (name = "crewMemberType")
public class CrewMemberType {
    @GeneratedValue
    @Id
    private int crewMemberTypeId;

    @NotBlank
    @Size(max = 20)
    @Column (name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crewMemberType")
    private Set<CrewMember> crewMembersOfType;

}
