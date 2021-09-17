package study.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.taxi.entity.OrderLog;

import java.util.UUID;

public interface OrderLogRepository extends JpaRepository<OrderLog, UUID> {
}
