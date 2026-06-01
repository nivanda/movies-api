package net.nivanda.moviesapi.controller;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.patch_dto.ActorPatchDTO;
import net.nivanda.moviesapi.patch_dto.GenrePatchDTO;
import net.nivanda.moviesapi.service.GenreService;
import net.nivanda.moviesapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService service;
    private final MovieService movieService;

    public GenreController(GenreService service, MovieService movieService) {
        this.service = service;
        this.movieService = movieService;
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return service.create(genre);
    }

    @GetMapping
    public List<Genre> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Genre getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public Genre patch(@PathVariable Long id, @RequestBody GenrePatchDTO dto) {
        Genre genre = service.findById(id);

        if (dto.getName() != null) genre.setName(dto.getName());

        if (dto.getMovieIDs() != null) {
            Set<Movie> movies = dto.getMovieIDs().stream().map(movieService::findById).collect(Collectors.toSet());
            genre.setMovies(movies);
        }

        return service.update(id, genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
