package study.taxi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.taxi.data.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByFirstnameAndLastname(String firstname, String lastname);

    User findByUsername(String username);
}