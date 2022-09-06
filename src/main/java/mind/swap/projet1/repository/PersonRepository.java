package mind.swap.projet1.repository;

import mind.swap.projet1.modelPerson.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    List<Person> personList;

    public PersonRepository() {
        personList = new ArrayList<>(List.of(
                Person.builder()
                        .id(1)
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
                        .build())) ;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Person addPerson(Person person) {
        personList.add(person);
        return person;
    }

    public List<Person> findByName(String name) {
        return personList.stream()
                .filter(person -> person.getName().equals(name))
                .toList();
    }
}
