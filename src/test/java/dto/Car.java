package dto;

import lombok.*;

@Data
@AllArgsConstructor
public class Car {

    private final String make;
    private final String model;

    private Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.make;
    }

    private static class CarBuilder {
        private String make;
        private String model;

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
