package veil.dev.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import veil.dev.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
