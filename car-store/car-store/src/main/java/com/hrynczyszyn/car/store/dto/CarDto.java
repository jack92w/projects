package com.hrynczyszyn.car.store.dto;

import com.hrynczyszyn.car.store.entity.enumeration.FuelType;
import com.hrynczyszyn.car.store.entity.enumeration.TransmissionType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDto {

    private Long id;
    @javax.validation.constraints.NotNull
    private String brand;
    @javax.validation.constraints.NotNull
    private String model;
    @javax.validation.constraints.NotNull
    private int productionYear;
    @javax.validation.constraints.NotNull
    private FuelType fuelType;
    @javax.validation.constraints.NotNull
    private TransmissionType transmissionType;
    @javax.validation.constraints.NotNull
    private double displacement;
    @javax.validation.constraints.NotNull
    private int horsePower;
}
