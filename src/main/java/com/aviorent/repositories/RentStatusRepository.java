package com.aviorent.repositories;

import com.aviorent.models.RentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentStatusRepository extends JpaRepository <RentStatus, Long> {
}
