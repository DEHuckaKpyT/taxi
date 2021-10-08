package study.taxi.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    String username;

    String lastname;

    String firstname;

    String password;

    String number;

    String email;
}
