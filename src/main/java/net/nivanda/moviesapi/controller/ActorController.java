package net.nivanda.moviesapi.controller;


import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.patch_dto.ActorPatchDTO;
import net.nivanda.moviesapi.service.ActorService;
import net.nivanda.moviesapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService service;
    private final MovieService movieService;

    public ActorController(ActorService service, MovieService movieService) {
        this.service = service;
        this.movieService = movieService;
    }

    @GetMapping("?name={name}")
    public List<Actor> filterByName(@PathVariable String name) {
        return service.filterByName(name);
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

    @PatchMapping("/{id}")
    public Actor patch(@PathVariable Long id, @RequestBody ActorPatchDTO dto) {
        Actor actor = service.findById(id);

        if (dto.getName() != null) actor.setName(dto.getName());
        if (dto.getBirthDate() != null) actor.setBirthDate(dto.getBirthDate());

        if (dto.getMovieIDs() != null) {
            Set<Movie> movies = dto.getMovieIDs().stream().map(movieService::findById).collect(Collectors.toSet());
            actor.setMovies(movies);
        }

        return service.update(id, actor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
