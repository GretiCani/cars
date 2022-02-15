package com.carseller.cars.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "wheels_type")
public class WheelsType extends BaseEntity{
    @Column(name = "type",unique = true)
    private String type;
}
