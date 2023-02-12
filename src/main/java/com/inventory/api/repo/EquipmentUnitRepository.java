package com.inventory.api.repo;

import com.inventory.api.model.EquipmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentUnitRepository extends JpaRepository<EquipmentUnit, Long> {
}
