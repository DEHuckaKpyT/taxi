package study.taxi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.taxi.data.entity.OrderState;

import java.util.UUID;

@Repository
public interface OrderStateRepository  extends JpaRepository<OrderState, UUID> {
}