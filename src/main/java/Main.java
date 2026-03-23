import car.CarAbstract;
import car.Engine;
import car.constant.BodyType;
import car.constant.TransmissionType;
import car.impl.*;

//its Main origin”
void main() {
    Renault logan = Renault.builder()
            .model("Logan")
            .color("white")
            .bodyType(BodyType.SEDAN)
            .transmissionType(TransmissionType.MANUAL)
            .engine(Engine.builder().model("K7M").power(84).capacity(1.6).build())
            .yearOfManufacture(2020)
            .build();

    Audi tt = Audi.builder()
            .model("TT")
            .color("silver")
            .bodyType(BodyType.COUPE)
            .transmissionType(TransmissionType.DSG)
            .engine(Engine.builder().model("2.0 TFSI").power(200).capacity(2.0).build())
            .yearOfManufacture(2007)
            .build();

    Audi rs6 = Audi.builder()
            .model("RS6")
            .color("blue")
            .bodyType(BodyType.UNIVERSAL)
            .transmissionType(TransmissionType.DSG)
            .engine(Engine.builder().model("4.0 TFSI V8").power(560).capacity(4.0).build())
            .yearOfManufacture(2018)
            .build();

    Toyota supra = Toyota.builder()
            .model("Supra")
            .color("red")
            .bodyType(BodyType.HATCHBACK)
            .transmissionType(TransmissionType.MANUAL)
            .engine(Engine.builder().model("2JZ-GTE").power(280).capacity(3.0).build())
            .yearOfManufacture(1996)
            .build();

    Lada niva = Lada.builder()
            .model("Niva")
            .color("black")
            .bodyType(BodyType.SUV)
            .transmissionType(TransmissionType.MANUAL)
            .engine(Engine.builder().model("ВАЗ-21214").power(80).capacity(1.7).build())
            .yearOfManufacture(1977)
            .build();

    Toyota landCruiser = Toyota.builder()
            .model("Land Cruiser")
            .color("black")
            .bodyType(BodyType.SUV)
            .transmissionType(TransmissionType.AUTOMATIC)
            .engine(Engine.builder().model("1UR-FE").power(309).capacity(4.6).build())
            .yearOfManufacture(2021)
            .build();

    Chevrolet camaro = Chevrolet.builder()
            .model("Camaro")
            .color("yellow")
            .bodyType(BodyType.CABRIOLET)
            .transmissionType(TransmissionType.AUTOMATIC)
            .engine(Engine.builder().model("LGX").power(335).capacity(3.5).build())
            .yearOfManufacture(2015)
            .build();

    Chevrolet tahoe = Chevrolet.builder()
            .model("Tahoe")
            .color("black")
            .bodyType(BodyType.SUV)
            .transmissionType(TransmissionType.AUTOMATIC)
            .engine(Engine.builder().model("L84").power(560).capacity(4.0).build())
            .yearOfManufacture(2023)
            .build();

    Lada vesta = Lada.builder()
            .model("Vesta Sport")
            .color("green")
            .bodyType(BodyType.SEDAN)
            .transmissionType(TransmissionType.MANUAL)
            .engine(Engine.builder().model("ВАЗ-21179").power(145).capacity(1.8).build())
            .yearOfManufacture(2018)
            .build();

    Renault duster = Renault.builder()
            .model("Duster")
            .color("silver")
            .bodyType(BodyType.SUV)
            .transmissionType(TransmissionType.MANUAL)
            .engine(Engine.builder().model("H4M").power(114).capacity(1.6).build())
            .yearOfManufacture(2021)
            .build();

    List<CarAbstract> cars = List.of(duster, logan, vesta, tahoe, camaro, rs6, landCruiser, niva, supra, tt);

    System.out.println("Цвет Весты до изменения цвета: " + vesta.getColor());
    vesta.changeGreenToRed();
    System.out.println("Цвет Весты после изменения цвета: " + vesta.getColor());
    System.out.println();

    System.out.println("Список авто, выпущенных после 2006: ");
    List<String> modernCars = CarAbstract.getModernAutos(cars);
    for (String car : modernCars) System.out.println(car);
    System.out.println();

    System.out.println("Группировка моделей с мощностью > 200 л.с. по типу кузова: ");
    System.out.println(CarAbstract.groupByBodyType(cars));
}
