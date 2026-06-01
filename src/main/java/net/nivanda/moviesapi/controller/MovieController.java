package net.nivanda.moviesapi.controller;


import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.patch_dto.MoviePatchDTO;
import net.nivanda.moviesapi.service.ActorService;
import net.nivanda.moviesapi.service.GenreService;
import net.nivanda.moviesapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;
    private final ActorService actorService;
    private final GenreService genreService;

    public MovieController(MovieService service, ActorService actorService, GenreService genreService) {
        this.service = service;
        this.actorService = actorService;
        this.genreService = genreService;
    }

    @GetMapping("?genre={genreId}")
    public List<Movie> filterByGenre(@PathVariable Long genreId) {
        return service.filterByGenre(genreId);
    }

    @GetMapping("?year={releaseYear}")
    public List<Movie> filterByReleaseYear(@PathVariable Integer releaseYear) {
        return service.filterByReleaseYear(releaseYear);
    }

    @GetMapping("?actor={actorId}")
    public List<Movie> filterByActor(@PathVariable Long actorId) {
        return service.filterByActor(actorId);
    }

    @GetMapping("/{movieId}/actors")
    public List<Actor> getActorsInMovie(@PathVariable Long movieId) {
        return service.getActorsByMovieId(movieId);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return service.create(movie);
    }

    @GetMapping
    public List<Movie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Movie getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public Movie patch(@PathVariable Long id, @RequestBody MoviePatchDTO dto) {
        Movie movie = service.findById(id);

        if (dto.getTitle() != null) movie.setTitle(dto.getTitle());
        if (dto.getReleaseYear() != null) movie.setReleaseYear(dto.getReleaseYear());
        if (dto.getDuration() != null) movie.setDuration(dto.getDuration());

        if (dto.getActorIDs() != null) {
            Set<Actor> actors = dto.getActorIDs().stream().map(actorService::findById).collect(Collectors.toSet());
            movie.setActors(actors);
        }

        if (dto.getGenreIDs() != null) {
            Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::findById).collect(Collectors.toSet());
            movie.setGenres(genres);
        }

        return service.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
