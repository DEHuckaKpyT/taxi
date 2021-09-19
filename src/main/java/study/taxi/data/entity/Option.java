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
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue
    @Column(name = "option_id")
    UUID optionId;

    String optionName;

    @ManyToMany(mappedBy = "options")
    Set<Order> orders;
}
