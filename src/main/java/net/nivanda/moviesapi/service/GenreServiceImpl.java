package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.repository.GenreRepository;
import net.nivanda.moviesapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepository repo;

    public GenreServiceImpl(GenreRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Genre> getAll() {
        return repo.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Genre create(Genre genre) {
        return repo.save(genre);
    }

    @Override
    public Genre update(Long id, Genre updated) {
        Genre genre = repo.findById(id).orElseThrow();
        genre.setName(updated.getName());
        genre.setMovies(updated.getMovies());

        return repo.save(genre);
    }

    @Override
    public List<Movie> getMoviesByGenreId(Long id) {
        return new ArrayList<>(repo.findById(id).orElseThrow().getMovies());
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
