package study.taxi.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderLog {

    @Id
    @GeneratedValue
    UUID logId;

    @ManyToOne
    Order order;

    LocalDateTime changeDateTime;

    @ManyToOne
    OrderState state;

    public Order getOrder() {
        return order;
    }

    public OrderState getState() {
        return state;
    }
}
