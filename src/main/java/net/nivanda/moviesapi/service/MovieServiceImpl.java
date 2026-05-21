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
    private final ActorRepository actorRepo;

    public MovieServiceImpl(MovieRepository repo, GenreRepository genreRepo, ActorRepository actorRepo) {
        this.repo = repo;
        this.genreRepo = genreRepo;
        this.actorRepo = actorRepo;
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
    public Movie patchTitle(Long id, String title) {
        Movie movie = repo.findById(id).orElseThrow();
        movie.setTitle(title);

        return repo.save(movie);
    }

    @Override
    public Movie patchReleaseYear(Long id, int releaseYear) {
        Movie movie = repo.findById(id).orElseThrow();
        movie.setReleaseYear(releaseYear);

        return repo.save(movie);
    }

    @Override
    public Movie patchDuration(Long id, int duration) {
        Movie movie = repo.findById(id).orElseThrow();
        movie.setDuration(duration);

        return repo.save(movie);
    }

    @Override
    public Movie patchGenres(Long id, List<Long> genreIDs) {
        Movie movie = repo.findById(id).orElseThrow();
        Set<Genre> originalGenres = movie.getGenres();
        List<Genre> genresToAdd = new ArrayList<>();
        List<Genre> genresToRemove = new ArrayList<>();

        for (Long genreId : genreIDs) {
            Genre genre = genreRepo.findById(genreId).orElseThrow();
            if (!originalGenres.contains(genre)) {
                genresToAdd.add(genre);
            }
        }

        for (Genre originalGenre : originalGenres) {
            boolean genreFound = false;
            for (Long genreId : genreIDs) {
                genreFound = originalGenre == genreRepo.findById(genreId).orElseThrow();
            }
            if (!genreFound) genresToRemove.add(originalGenre);
        }

        for (Genre genre : genresToAdd) movie.addGenre(genre);
        for (Genre genre : genresToRemove) movie.removeGenre(genre);

        return repo.save(movie);
    }

    @Override
    public Movie patchActors(Long id, List<Long> actorIDs) {
        Movie movie = repo.findById(id).orElseThrow();
        Set<Actor> originalActors = movie.getActors();
        List<Actor> actorsToAdd = new ArrayList<>();
        List<Actor> actorsToRemove = new ArrayList<>();

        for (Long actorId : actorIDs) {
            Actor actor = actorRepo.findById(actorId).orElseThrow();
            if (!originalActors.contains(actor)) {
                actorsToAdd.add(actor);
            }
        }

        for (Actor originalActor : originalActors) {
            boolean actorFound = false;
            for (Long actorId : actorIDs) {
                actorFound = originalActor == actorRepo.findById(actorId).orElseThrow();
            }
            if (!actorFound) actorsToRemove.add(originalActor);
        }

        for (Actor actor : actorsToAdd) movie.addActor(actor);
        for (Actor actor : actorsToRemove) movie.removeActor(actor);

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
