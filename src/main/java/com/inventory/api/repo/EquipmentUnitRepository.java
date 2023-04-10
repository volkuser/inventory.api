package com.inventory.api.repo;

import com.inventory.api.model.EquipmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EquipmentUnitRepository extends JpaRepository<EquipmentUnit, Long> {
    Optional<EquipmentUnit> findByGuidCode(UUID guidCode);
}
