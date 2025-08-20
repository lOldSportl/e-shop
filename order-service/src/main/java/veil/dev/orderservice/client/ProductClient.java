package veil.dev.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import veil.dev.orderservice.dto.ProductDto;

@Component
public class ProductClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8082/products";

    public ProductDto getProductById(Long id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, ProductDto.class);
        } catch (Exception e) {
            return null;
        }
    }
}
