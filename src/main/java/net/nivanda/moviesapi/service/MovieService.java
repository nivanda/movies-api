package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie findById(Long id);

    List<Movie> filterByGenre(Long id);

    List<Movie> filterByReleaseYear(int releaseYear);

    Movie create(Movie movie);

    Movie update(Long id, Movie updated);

    List<Actor> getActorsByMovieId(Long id);

    void delete(Long id);
}
