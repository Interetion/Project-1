package mind.swap.projet1.modelCar;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;

    private String color;

    private Integer numberOfSeats;

    public Car() {

    }

    public static void add(Car car) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
