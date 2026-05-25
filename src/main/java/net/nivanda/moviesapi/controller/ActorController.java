package net.nivanda.moviesapi.controller;


import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    private final ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @PostMapping
    public Actor create(@RequestBody Actor actor) {
        return service.create(actor);
    }

    @GetMapping
    public List<Actor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Actor getOne(@PathVariable Long id) {
        return service.findById(id);
    }

}
