package car.impl;

import car.CarAbstract;
import car.Engine;
import car.constant.BodyType;
import car.constant.TransmissionType;
import lombok.Builder;

public class Toyota extends CarAbstract {
    @Builder
    public Toyota(String model, String color, BodyType bodyType, int yearOfManufacture, Engine engine, TransmissionType transmissionType) {
        super(model, color, bodyType, yearOfManufacture, engine, transmissionType);
    }
}
