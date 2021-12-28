package study.taxi.api.dto;

import lombok.*;
import study.taxi.data.entity.User;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    UUID orderId;
    LocalDateTime createDateTime;
    String points;
    int price;
    String comment;
    String otherNumber;
    DriverDto driver;
    CarDto usingCar;
    CarTypeDto type;
    Set<OptionDto> options;
}
