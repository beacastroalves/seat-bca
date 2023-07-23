package com.github.beacastroalves.seatbca.controllers;

import com.github.beacastroalves.seatbca.models.User;
import com.github.beacastroalves.seatbca.repositories.UserRepository;
import org.antlr.v4.runtime.ListTokenSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public User deleteById(@PathVariable Long id) {
        Optional<User> optional = this.repository.findById(id);

        if (optional.isPresent()) {
            this.repository.deleteById(id);

            return optional.get();
        }
        
        return null;
    }
}
