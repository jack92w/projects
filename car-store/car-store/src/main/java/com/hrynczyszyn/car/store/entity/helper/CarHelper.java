package com.hrynczyszyn.car.store.entity.helper;

import com.hrynczyszyn.car.store.entity.enumeration.FuelType;
import com.hrynczyszyn.car.store.entity.enumeration.TransmissionType;
import lombok.Data;

@Data
public class CarHelper {

    private Long id;
    private String brand;
    private String model;
    private int productionYear;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private double displacement;
    private int horsePower;
}
