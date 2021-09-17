package study.taxi.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    Employee employee;

    @ManyToOne
    User user;

    @ManyToOne
    Car usingCar;

    @ManyToMany
    @JoinTable(name = "order_car_type",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    Set<CarType> types;

    @ManyToMany
    @JoinTable(name = "order_option",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    Set<Option> options;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Car getUsingCar() {
        return usingCar;
    }

    public User getUser() {
        return user;
    }
}
