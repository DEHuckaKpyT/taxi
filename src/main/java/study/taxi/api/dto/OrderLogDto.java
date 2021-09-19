package study.taxi.api.dto;

import lombok.*;
import study.taxi.data.entity.Order;
import study.taxi.data.entity.OrderState;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLogDto {

    UUID logId;
    Order order;
    LocalDateTime changeDateTime;
    OrderState state;
}
