package car;

import car.constant.BodyType;
import car.constant.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public abstract class CarAbstract {
    private String model;
    private String color;
    private BodyType bodyType;
    private int yearOfManufacture;
    private Engine engine;
    private TransmissionType transmissionType;

    public void changeGreenToRed() {
        if (this.getColor().equals("green")) this.setColor("red");
        else throw new RuntimeException("Цвет авто - не зеленый");
    }

    public static List<String> getModernAutos(List<CarAbstract> cars) {
        return cars.stream()
                .map(car -> {
                    if (car.getYearOfManufacture() > 2006) return car.toString();
                    else return "Устаревший авто";
                })
                .toList();
    }

    /**
     * Группировка авто по типу кузова с мощностью двигателя более 200 л.с
     * тип кузова -> (вывод списка соответствующих моделей авто)
     */
    public static Map<BodyType, List<String>> groupByBodyType(List<CarAbstract> cars) {
        return cars.stream()
                .filter(car -> car.getEngine().getPower() > 200)
                .collect(Collectors.groupingBy(CarAbstract::getBodyType,
                        Collectors.mapping(CarAbstract::getModel, Collectors.toList())));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{" +
                "model='" + this.getModel() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", bodyType=" + this.getBodyType() +
                ", yearOfManufacture=" + this.getYearOfManufacture() +
                ", engine=" + this.getEngine() +
                ", transmissionType=" + this.getTransmissionType() +
                '}';
    }
}
