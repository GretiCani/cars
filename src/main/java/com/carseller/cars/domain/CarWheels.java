package com.carseller.cars.domain;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "wheels",uniqueConstraints = {@UniqueConstraint(columnNames = {"size","wheels_type"})})
public class CarWheels extends BaseEntity{
    @Column(name = "size")
    private String size;
    @ManyToOne
    @JoinColumn(name = "wheels_type")
    private WheelsType type;

}
