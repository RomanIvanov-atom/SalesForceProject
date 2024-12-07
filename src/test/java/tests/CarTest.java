package tests;

import dto.Car;
import lombok.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CarTest {

    @Test
    public void checkCar() {
        Car car = new Car("BMW", "x5");
        Car car1 = new Car("Tesla", "i8");
        Assert.assertEquals(car, car1);
    }
}
