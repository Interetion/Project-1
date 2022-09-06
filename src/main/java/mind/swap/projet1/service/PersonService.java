package mind.swap.projet1.service;

import mind.swap.projet1.modelCar.Car;
import mind.swap.projet1.modelPerson.Person;
import mind.swap.projet1.repository.PersonJpaRepository;
import mind.swap.projet1.repository.PersonRepository;
import mind.swap.projet1.resourse.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonJpaRepository personJpaRepository;

    public PersonService(PersonRepository personRepository, PersonJpaRepository personJpaRepository) {
        this.personRepository = personRepository;
        this.personJpaRepository = personJpaRepository;
    }

    public Person getPerson() {
        return  Person.builder()
                .name("John")
                .surname("Doe")
                .age(30)
                .city("New York")
                .country("USA")
                .email("aluno@swap.pt")
                .phone("+1-212-555-1234")
                .address("123 Main Street")
                .zip("10001")
                .password("password")
                .confirmPassword("password")
                .build();
    }

    public Person createPerson(Person person) {
        return personRepository.addPerson(person);
    }

    public Person createPersonJpa(Person person) {
        return personJpaRepository.save(person);
    }
    public List<Person> getPersonListJpa() {
        return personJpaRepository.findAll();
    }

    public List<Person> getPersonList() {
        return personRepository.getPersonList();
    }

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }



    public void deletePersonById(Integer id) {
        personJpaRepository.deleteById(id);
    }

    public ResponseEntity<Person> updatePersonById(Integer id, Person personDetails) {
      Person updatePerson = personJpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This person doesn't exist with this id: " + id));

        updatePerson.setName(personDetails.getName());
        updatePerson.setSurname(personDetails.getSurname());
        updatePerson.setAge(personDetails.getAge());
        updatePerson.setCity(personDetails.getCity());
        updatePerson.setCountry(personDetails.getCountry());
        updatePerson.setEmail(personDetails.getEmail());
        updatePerson.setPhone(personDetails.getPhone());
        updatePerson.setAddress(personDetails.getAddress());
        updatePerson.setZip(personDetails.getZip());
        updatePerson.setPassword(personDetails.getPassword());
        updatePerson.setConfirmPassword(personDetails.getConfirmPassword());

       personJpaRepository.save(updatePerson);

        return ResponseEntity.ok(updatePerson);
    }
}
