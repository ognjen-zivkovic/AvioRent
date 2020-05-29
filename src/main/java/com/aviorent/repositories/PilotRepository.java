package com.aviorent.repositories;

import com.aviorent.models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
