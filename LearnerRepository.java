package com.ironlady.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ironlady.entity.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
