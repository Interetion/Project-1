package mind.swap.projet1.controllerCar;
import mind.swap.projet1.modelCar.Car;
import mind.swap.projet1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {

        @Autowired

        private CarService carServiceAuto;
        private CarService carService;



        public CarController(CarService carService) {
            this.carService = carService;
        }

        @GetMapping
        public List<Car> getAllCar() {

            List <Car> carList= carService.getCarListJpa();//get JPA

            return carList;

        }

        @PostMapping
        public  Car createCar(@RequestBody Car car) {
           Car car1= carService.createCarJpa(car);

            return car1 ;
        }


        @GetMapping("/todos-juntos") //need to come before @GetMapping("/{name}")
        public List<Car> findByColor(@PathVariable String color) {
            return carService.findByColor(color) ;
        }

        @GetMapping("/{color} ⁄ {id}")
        public List<Car> findByCar(@PathVariable String color, @PathVariable Long id) {
            return carService.findByColor(color) ;
        }
    @PutMapping("/put/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCarById(id, car);
    }
    @DeleteMapping ("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        carService.deleteCarById(id);
    }
}



