package study.taxi.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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
