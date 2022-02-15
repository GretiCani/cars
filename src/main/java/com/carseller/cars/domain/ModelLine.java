package com.carseller.cars.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "model_line")
public class ModelLine extends BaseEntity{
    @Column(name = "line",unique = true)
    private String line;
}
