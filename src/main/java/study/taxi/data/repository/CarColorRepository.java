package study.taxi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.taxi.data.entity.CarColor;

import java.util.UUID;

@Repository
public interface CarColorRepository  extends JpaRepository<CarColor, UUID> {
}
