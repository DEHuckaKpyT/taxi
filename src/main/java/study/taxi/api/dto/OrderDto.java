package study.taxi.api.dto;

import lombok.*;
import study.taxi.data.entity.*;

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
    int tip;
    String otherNumber;
    Driver driver;
    User user;
    Car usingCar;
    Set<CarType> types;
    Set<Option> options;
}
