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
public class User {

    @Id
    @GeneratedValue
    UUID userId;

    @Column(unique = true)
    String username;

    String lastname;

    String firstname;

    String password;

    String number;

    String email;
}
