package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Movie;

import java.util.List;

public interface ActorService {

    List<Actor> getAll();

    Actor findById(Long id);

    List<Actor> filterByName(String name);

    Actor create(Actor actor);

    Actor update(Long id, Actor updated);

    List<Movie> getMoviesByActorId(Long id);

    void delete(Long id);
}
