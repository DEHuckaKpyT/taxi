package study.taxi.api.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {

    UUID driverId;
    String lastname;
    String firstname;
    String password;
    String passport;
    CarDto car;
}
