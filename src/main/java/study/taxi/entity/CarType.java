package study.taxi.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "car_type")
public class CarType {

    @Id
    @GeneratedValue
    @Column(name = "type_id")
    UUID typeId;

    String typeName;

    @ManyToMany(mappedBy = "types")
    Set<Order> orders;
}
