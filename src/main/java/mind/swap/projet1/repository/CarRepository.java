package mind.swap.projet1.repository;
import mind.swap.projet1.modelCar.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CarRepository {
    List<Car> carList = new ArrayList<>(List.of(
            Car.builder()
               .color("yellow")
               .numberOfSeats(5)
               .build()));



    public List<Car> getCarList() {
        return carList;
    }

    public Car addCar(Car car) {
       Car.add(car);
        return car;
    }

    public List<Car> findByColor(String color) {
        return carList.stream()
                .toList();
    }
}
