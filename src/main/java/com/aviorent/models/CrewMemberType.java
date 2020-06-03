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
    private long crewMemberTypeId;

    @NotBlank(message = "Crew member type is required")
    @Size(max = 20, message = "Crew member type must not exceed 20 characters.")
    @Column (name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crewMemberType")
    private Set<CrewMember> crewMembersOfType;

    public long getCrewMemberTypeId() {
        return crewMemberTypeId;
    }

    public void setCrewMemberTypeId(long crewMemberTypeId) {
        this.crewMemberTypeId = crewMemberTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
