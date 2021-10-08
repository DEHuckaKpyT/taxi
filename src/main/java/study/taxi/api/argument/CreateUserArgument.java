package study.taxi.api.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserArgument {

    String username;

    String lastname;

    String firstname;

    String password;

    String number;

    String email;
}
