package veil.dev.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private UserDto user;
    private List<Long> productIds;
}
