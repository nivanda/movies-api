package net.nivanda.moviesapi.service;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.repository.ActorRepository;
import net.nivanda.moviesapi.repository.GenreRepository;
import net.nivanda.moviesapi.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovieServiceImpl implements MovieService{

    private final MovieRepository repo;
    private final GenreRepository genreRepo;

    public MovieServiceImpl(MovieRepository repo, GenreRepository genreRepo) {
        this.repo = repo;
        this.genreRepo = genreRepo;
    }

    @Override
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<Movie> filterByGenre(Long id) {
        return new ArrayList<>(genreRepo.findById(id).orElseThrow().getMovies());
    }

    @Override
    public List<Movie> filterByReleaseYear(int releaseYear) {
        List<Movie> allMovies = repo.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : allMovies) {
            if (movie.getReleaseYear() == releaseYear) filteredMovies.add(movie);
        }

        return filteredMovies;
    }

    @Override
    public Movie create(Movie movie) {
        return repo.save(movie);
    }

    @Override
    public Movie update(Long id, Movie updated) {
        Movie movie = repo.findById(id).orElseThrow();
        movie.setTitle(updated.getTitle());
        movie.setDuration(updated.getDuration());
        movie.setReleaseYear(updated.getReleaseYear());
        movie.setActors(updated.getActors());
        movie.setGenres(updated.getGenres());

        return repo.save(movie);
    }

    @Override
    public List<Actor> getActorsByMovieId(Long id) {
        return new ArrayList<>(repo.findById(id).orElseThrow().getActors());
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
