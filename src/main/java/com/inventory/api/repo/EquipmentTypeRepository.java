package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.EquipmentType;

import java.util.Optional;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
        Optional<EquipmentType> findFirstByOrderByEquipmentTypeIdAsc();
}

