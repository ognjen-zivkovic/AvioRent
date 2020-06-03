package com.aviorent.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "rentStatus")
public class RentStatus {
    @GeneratedValue
    @Id
    private long rentStatusId;

    @NotBlank(message = "Status is required")
    @Column (name = "status")
    private String status;

    @OneToMany(mappedBy = "rentStatus")
    private Set<Rent> rents;

    public long getRentStatusId() {
        return rentStatusId;
    }

    public void setRentStatusId(long rentStatusId) {
        this.rentStatusId = rentStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
