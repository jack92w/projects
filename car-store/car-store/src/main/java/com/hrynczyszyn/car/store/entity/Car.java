package com.hrynczyszyn.car.store.entity;

import com.hrynczyszyn.car.store.entity.enumeration.FuelType;
import com.hrynczyszyn.car.store.entity.enumeration.TransmissionType;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car_tbl")
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @Column(
            name = "brand",
            nullable = false)
    private String brand;
    @Column(
            name = "model",
            nullable = false)
    private String model;
    @Column(
            name = "production_year",
            nullable = false)
    private int productionYear;
    @Column(
            name = "fuel_type",
            nullable = false)
    private FuelType fuelType;
    @Column(
            name = "transmission_type",
            nullable = false)
    private TransmissionType transmissionType;
    @Column(
            name = "displacement",
            nullable = false)
    private double displacement;
    @Column(
            name = "horse_power",
            nullable = false)
    private int horsePower;
}
