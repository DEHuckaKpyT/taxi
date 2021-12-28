package study.taxi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.taxi.api.dto.OrderDto;
import study.taxi.api.dto.OrderProjection;
import study.taxi.data.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

//    @Query(value = "select " +
//                   "    order_id as id," +
//                   "    create_date_time as createDateTime," +
//                   "    price as price," +
//                   "    type_name as type," +
//                   "    o.comment as comment " +
//                   "from public.\"order\" o " +
//                   "inner join public.\"user\" u on u.user_id = o.user_user_id " +
//                   "inner join public.\"car_type\" ct on o.type_type_id = ct.type_id " +
//                   "where u.user_id = cast(:userId as uuid)",
//           nativeQuery = true)
//    Optional<List<OrderProjection>> findAllByUserId(@Param("userId") UUID userId);

    List<Order> findAllByUserUserId(UUID userId);

}
