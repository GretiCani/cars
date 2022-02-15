package com.carseller.cars.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "model")
public class CarModel extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "from_year")
    private Integer from;
    @Column(name = "to_year")
    private Integer to;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_type")
    private ModelType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private ModelLine line;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id")
    private CarEngine carEngine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wheels_id")
    private CarWheels wheels;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CarModel parentModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogue_id")
    private CarCatalogue catalogue;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "parentModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarModel> submodels;

    @Builder
    public CarModel(String name, Integer from, Integer to, ModelType type, ModelLine line, CarEngine carEngine, CarWheels wheels, CarModel parentModel, CarCatalogue catalogue, List<CarModel> submodels) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.type = type;
        this.line = line;
        this.carEngine = carEngine;
        this.wheels = wheels;
        this.parentModel = parentModel;
        this.catalogue = catalogue;
        this.submodels = submodels;
    }
}
