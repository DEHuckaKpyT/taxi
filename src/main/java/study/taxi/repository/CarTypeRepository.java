package study.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.taxi.entity.CarType;

import java.util.UUID;

public interface CarTypeRepository extends JpaRepository<CarType, UUID> {
}
