package study.taxi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.taxi.data.entity.CarType;

import java.util.UUID;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, UUID> {
}
