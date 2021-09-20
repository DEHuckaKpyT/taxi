package study.taxi.api.dto;

import lombok.*;
import study.taxi.data.entity.CarColor;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    UUID carId;
    String number;
    String name;
    CarTypeDto type;
    int countOfPassengers;
    CarColor color;
}
