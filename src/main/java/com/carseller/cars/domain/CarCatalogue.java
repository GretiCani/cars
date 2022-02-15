package com.carseller.cars.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "catalogue")
public class CarCatalogue extends BaseEntity{
    @Column(name = "brand",unique = true)
    private String brand;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "catalogue",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarModel> models;

    @Builder
    public CarCatalogue(String brand) {
        this.brand = brand;
    }
}
