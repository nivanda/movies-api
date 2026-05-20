package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;

import java.util.List;

public interface GenreService {

    List<Genre> getAll();

    Genre findById(Long id);

    Genre create(Genre genre);

    Genre patchName(Long id, String name);

    Genre patchMovies(Long id, List<Long> movieIDs);

    List<Movie> getMoviesByGenreId(Long id);

    void delete(Long id);
}
