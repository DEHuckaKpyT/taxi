package study.taxi.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue
    UUID driverId;

    String lastname;

    String firstname;

    String password;

    String passport;

    @ManyToOne
    Car car;
}