package mind.swap.projet1.modelPerson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;


    @Builder
    @AllArgsConstructor
    @Data
    @Entity
    public class Person {


        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        private String name;
        private String surname;
        private Integer age;
        private String city;
        private String country;
        private String email;
        private String phone;
        private String address;
        private String zip;
        private String password;
        private String confirmPassword;


        public Person() {

        }
    }

