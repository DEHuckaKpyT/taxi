package study.taxi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CarColor {

    @Id
    @GeneratedValue
    UUID colorId;

    String colorName;
}
