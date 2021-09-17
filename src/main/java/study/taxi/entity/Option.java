package study.taxi.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

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
