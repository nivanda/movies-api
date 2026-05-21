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
    private final MovieRepository movieRepo;

    public GenreServiceImpl(GenreRepository repo, MovieRepository movieRepo) {
        this.repo = repo;
        this.movieRepo = movieRepo;
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
    public Genre patchName(Long id, String name) {
        Genre genre = repo.findById(id).orElseThrow();
        genre.setName(name);

        return repo.save(genre);
    }

    @Override
    public Genre patchMovies(Long id, List<Long> movieIDs) {
        Genre genre = repo.findById(id).orElseThrow();
        Set<Movie> originalMovies = genre.getMovies();
        List<Movie> moviesToAdd = new ArrayList<>();
        List<Movie> moviesToRemove = new ArrayList<>();

        for (Long movieId : movieIDs) {
            Movie movie = movieRepo.findById(movieId).orElseThrow();
            if (!originalMovies.contains(movie)) {
                moviesToAdd.add(movie);
            }
        }

        for (Movie originalMovie : originalMovies) {
            boolean movieFound = false;
            for (Long movieId : movieIDs) {
                movieFound = originalMovie == movieRepo.findById(movieId).orElseThrow();
            }
            if (!movieFound) moviesToRemove.add(originalMovie);
        }

        for (Movie movie : moviesToAdd) genre.addMovie(movie);
        for (Movie movie : moviesToRemove) genre.removeMovie(movie);

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
