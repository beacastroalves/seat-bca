package com.github.beacastroalves.seatbca.controllers;

import com.github.beacastroalves.seatbca.controllers.dto.request.SpotRequest;
import com.github.beacastroalves.seatbca.models.Spot;
import com.github.beacastroalves.seatbca.repositories.SpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/spots")
public class SpotController {
    private final SpotRepository repository;

    public SpotController(SpotRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Spot> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Spot findById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @PostMapping
    public Spot store(@RequestBody SpotRequest request) {
        if (request.getName() == null) {
            return null;
        }
        return this.repository.save(new Spot(null, request.getName()));
    }

    @PutMapping("{id}")
    public Spot update(@PathVariable Long id, @RequestBody SpotRequest request) {
        Optional<Spot> optional = this.repository.findById(id);

        if (optional.isPresent()){
            Spot spot = optional.get();
            spot.setName(request.getName());

            return this.repository.save(spot);
        }
        return null;
    }


    @DeleteMapping("{id}")
    public Spot deleteById(@PathVariable Long id) {
        Optional<Spot> optional = repository.findById(id);

        if(optional.isPresent()){
            repository.deleteById(id);
            return optional.get();
        }

        return null;
    }


}
