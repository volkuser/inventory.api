package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}

