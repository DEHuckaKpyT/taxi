package study.taxi.api.dto;

import lombok.*;
import study.taxi.data.entity.User;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    String addressFrom;
    String addressTo;
    String distance;
    int price;
    String comment;
    int tip;
    String otherNumber;
    User user;//TODO
    String type;
    Set<OptionDto> options;
}
