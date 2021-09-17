package study.taxi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    UUID userId;

    String lastName;

    String firstName;

    String password;

    String number;

    String email;
}
