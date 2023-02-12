package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.EquipmentStatus;

public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatus, Long> {
}

