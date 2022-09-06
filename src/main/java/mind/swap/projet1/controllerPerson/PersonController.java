package mind.swap.projet1.controllerPerson;
import mind.swap.projet1.modelCar.Car;
import mind.swap.projet1.modelPerson.Person;
import mind.swap.projet1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")

public class PersonController {



    @Autowired
    private PersonService personServiceAuto;


        private final PersonService personService;

        public PersonController(PersonService personService) {
            this.personService = personService;
        }

        @GetMapping
        public List<Person> getAllPerson() {
            List<Person> personList1 = personService.getPersonListJpa();

            System.out.println(personList1);


            return personList1;

        }

        @PostMapping
        public Person createPerson(@RequestBody Person person) {
            Person person1 = personService.createPersonJpa(person);


            System.out.println(person1);

            return person1;
        }


        @GetMapping("/todos-juntos") //need to come before @GetMapping("/{name}")
        public List<Person> findByName1(@PathVariable String name) {
            return personService.findByName(name);
        }

        @GetMapping("/{name}/{id}")
        public List<Person> findByName(@PathVariable String name, @PathVariable int id) {
            return personService.findByName(name);
        }
    @PutMapping("/put/{id}")
    public ResponseEntity<Person> updateCarById(@PathVariable Integer id, @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }
    @DeleteMapping ("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        personService.deletePersonById(id);
    }

    }
