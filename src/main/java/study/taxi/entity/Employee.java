package study.taxi.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    UUID employeeId;

    String lastName;

    String firstName;

    String password;

    String passport;

    @ManyToOne
    Car car;

    public Car getCar() {
        return car;
    }
}