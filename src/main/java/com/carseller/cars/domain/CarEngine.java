package com.carseller.cars.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "engine",uniqueConstraints = {@UniqueConstraint(columnNames = {"power","engine_type"})})
public class CarEngine extends BaseEntity{
    @Column(name = "power")
    private Integer power;
    @ManyToOne
    @JoinColumn(name = "engine_type")
    private EngineType type;

}
