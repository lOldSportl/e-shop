package veil.dev.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import veil.dev.userservice.entity.User;
import veil.dev.userservice.repo.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "Deleted";
    }
}
