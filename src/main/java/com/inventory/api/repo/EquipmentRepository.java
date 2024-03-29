package com.inventory.api.repo;

import com.inventory.api.model.EquipmentType;
import com.inventory.api.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByEquipmentType(EquipmentType equipmentType);

    Optional<Equipment> findFirstByOrderByEquipmentIdAsc();
}

