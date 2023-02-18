package com.inventory.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @NotBlank
    @Size(max = 100)
    @Column(name = "model_name")
    private String modelName;

    @Size(max = 50)
    @Column(name = "product_code")
    private String productCode;

    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "equipment_type_id")
    private EquipmentType equipmentType;

    @Size(max = 50)
    @Column(name = "manufacturer")
    private String manufacturer;
}
