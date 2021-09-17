package study.taxi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class OrderState {

    @Id
    @GeneratedValue
    UUID stateId;

    String stateName;
}
