package com.aviorent.repositories;

import com.aviorent.models.CrewMember;
import com.aviorent.models.CrewMemberType;
import com.aviorent.models.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrewMemberRepository extends JpaRepository <CrewMember, Long> {
    Page<CrewMember> findAll(Pageable pageable);

}
