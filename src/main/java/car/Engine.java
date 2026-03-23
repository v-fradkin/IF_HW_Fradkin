package car;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Engine {
    private String model;
    private double capacity;
    private int power;
}
