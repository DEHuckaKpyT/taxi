package study.taxi.api.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    String addressFrom;
    String addressTo;
    int price;
    String comment;
    int tip;
    String otherNumber;
    //    User user;//TODO
    CarTypeDto type;
    Set<OptionDto> options;
}
