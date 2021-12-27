package study.taxi.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_type")
public class CarType {

    @Id
    @GeneratedValue
    @Column(name = "type_id")
    UUID typeId;

    String typeName;

    double coefficient;
}
