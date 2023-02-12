package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}

