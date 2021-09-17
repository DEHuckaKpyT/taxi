package study.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.taxi.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
