package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

