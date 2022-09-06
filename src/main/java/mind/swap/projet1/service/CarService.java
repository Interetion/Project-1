package mind.swap.projet1.service;
import mind.swap.projet1.modelCar.Car;
import mind.swap.projet1.repository.CarJpaRepository;
import mind.swap.projet1.repository.CarRepository;
import mind.swap.projet1.resourse.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarJpaRepository carJpaRepository;


    public CarService(CarRepository carRepository, CarJpaRepository carJpaRepository) {
        this.carRepository = carRepository;
        this.carJpaRepository = carJpaRepository;

    }

    public Car getCar() {

        return Car.builder()
                .color("yellow")
                .numberOfSeats(5)
                .build();
    }

    public Car createCar(Car car) {
        return carRepository.addCar(car);
    }

    public Car createCarJpa(Car car) {
        return carJpaRepository.save(car);
    }

    public List<Car> getCarListJpa() {
        return carJpaRepository.findAll();
    }

    public List<Car> getCarList() {
        return carRepository.getCarList();
    }

    public List<Car> findByColor(String color) {
        return carRepository.findByColor(color);
    }

    public void deleteCarById(Long id) {
        carJpaRepository.deleteById(id);
    }

    public ResponseEntity<Car> updateCarById(Long id, Car carDetails) {
        Car updateCar = carJpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This car doesn't exist with this id: " + id));

        updateCar.setColor(carDetails.getColor());

        updateCar.setNumberOfSeats(carDetails.getNumberOfSeats());

        carJpaRepository.save(updateCar);

        return ResponseEntity.ok(updateCar);
    }
}


