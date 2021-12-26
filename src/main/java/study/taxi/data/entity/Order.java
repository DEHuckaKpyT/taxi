package study.taxi.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    UUID orderId;

    LocalDateTime createDateTime;

    String points;

    int price;

    String comment;

    int tip;

    String otherNumber;

    @ManyToOne
    Driver driver;

    @ManyToOne
    User user;

    @ManyToOne
    Car usingCar;

    @ManyToOne
    CarType type;

    @ManyToMany
    @JoinTable(name = "order_option",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    Set<Option> options;
}
