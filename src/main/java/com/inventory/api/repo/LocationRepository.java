package com.inventory.api.repo;

import com.inventory.api.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.Location;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByTrainingCenterAndLocationNumber(TrainingCenter trainingCenter, String locationNumber);
}

