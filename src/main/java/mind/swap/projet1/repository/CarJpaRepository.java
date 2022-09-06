package mind.swap.projet1.repository;

import mind.swap.projet1.modelCar.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car, Long> {
}
