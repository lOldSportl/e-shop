package veil.dev.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import veil.dev.orderservice.client.UserClient;
import veil.dev.orderservice.dto.OrderDto;
import veil.dev.orderservice.dto.UserDto;
import veil.dev.orderservice.entity.Order;
import veil.dev.orderservice.repo.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @GetMapping("/{id}/full")
    public OrderDto getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        UserDto user = userClient.getUserById(order.getUserId());

        return new OrderDto(order.getId(), user, order.getProductIds());
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "Deleted order with id " + id;
    }
}
