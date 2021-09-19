package study.taxi.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue
    UUID carId;

    String number;

    String name;

    @ManyToOne
    CarType type;

    int CountOfPassengers;

    @ManyToOne
    CarColor color;

    public CarColor getColor() {
        return color;
    }

    public CarType getType() {
        return type;
    }
}
