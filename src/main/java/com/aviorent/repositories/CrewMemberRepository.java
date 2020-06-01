package com.aviorent.repositories;

import com.aviorent.models.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewMemberRepository extends JpaRepository <CrewMember, Long> {
}
