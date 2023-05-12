package tacos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(
            value = "SELECT * FROM Taco_Order WHERE city = Berlin",
            nativeQuery = true)
    List<Order> readOrdersWhereDeliveryIsBerlin();

//    Order save(Order order);
}
