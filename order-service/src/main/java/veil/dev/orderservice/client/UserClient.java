package veil.dev.orderservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import veil.dev.orderservice.dto.UserDto;


@Service
@RequiredArgsConstructor
public class UserClient {

    private final RestTemplate restTemplate;

    public UserDto getUserById(Long id) {

        String url = "http://localhost:8084/users/" + id;
        return restTemplate.getForObject(url, UserDto.class);
    }
}
