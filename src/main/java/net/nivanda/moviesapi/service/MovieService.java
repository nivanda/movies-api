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

    Movie patchTitle(Long id, String title);

    Movie patchReleaseYear(Long id, int releaseYear);

    Movie patchDuration(Long id, int duration);

    Movie patchGenres(Long id, List<Long> genreIDs);

    Movie patchActors(Long id, List<Long> actorIDs);

    List<Actor> getActorsByMovieId(Long id);

    void delete(Long id);
}
