package vn.seta.devops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ping")
    public String ping() {
        return "Pong!";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User editUser(@RequestBody User user) {
        // Save or update the user in the database
        return userRepository.save(user);
    }

    @PostMapping("/auth/login")
    public String login() {
        // Your login logic here
        return "Login successful!";
    }
}
``
