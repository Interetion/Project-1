package mind.swap.projet1.repository;

import mind.swap.projet1.modelPerson.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository <Person, Integer> {

}
