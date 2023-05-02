package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.TrainingCenter;

import java.util.Optional;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    TrainingCenter findByTrainingCenterId(Long trainingCenterId);
    Optional<TrainingCenter> findFirstByOrderByTrainingCenterIdAsc();
}

