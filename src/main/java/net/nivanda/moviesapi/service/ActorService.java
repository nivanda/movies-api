package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface ActorService {

    List<Actor> getAll();

    Actor findById(Long id);

    List<Actor> filterByName(String name);

    Actor create(Actor actor);

    Actor patchName(Long id, String name);

    Actor patchBirthDate(Long id, LocalDate birthDate);

    Actor patchMovies(Long id, List<Long> movieIDs);

    List<Movie> getMoviesByActorId(Long id);

    void delete(Long id);
}
