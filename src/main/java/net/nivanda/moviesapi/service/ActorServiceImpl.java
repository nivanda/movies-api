package net.nivanda.moviesapi.service;


import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.repository.ActorRepository;
import net.nivanda.moviesapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository repo;
    private final MovieRepository movieRepo;

    public ActorServiceImpl(ActorRepository repo, MovieRepository movieRepo) {
        this.repo = repo;
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Actor> getAll() {
        return repo.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<Actor> filterByName(String name) {
        List<Actor> allActors = repo.findAll();
        List<Actor> filteredActors = new ArrayList<>();

        for (Actor actor : allActors) {
            if (actor.getName().equals(name)) filteredActors.add(actor);
        }

        return filteredActors;
    }

    @Override
    public Actor create(Actor actor) {
        return repo.save(actor);
    }

    @Override
    public Actor patchName(Long id, String name) {
        Actor actor = repo.findById(id).orElseThrow();
        actor.setName(name);

        return repo.save(actor);
    }

    @Override
    public Actor patchBirthDate(Long id, LocalDate birthDate) {
        Actor actor = repo.findById(id).orElseThrow();
        actor.setBirthDate(birthDate);

        return repo.save(actor);
    }

    @Override
    public Actor patchMovies(Long id, List<Long> movieIDs) {
        Actor actor = repo.findById(id).orElseThrow();
        Set<Movie> originalMovies = actor.getMovies();
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

        for (Movie movie : moviesToAdd) actor.addMovie(movie);
        for (Movie movie : moviesToRemove) actor.removeMovie(movie);

        return repo.save(actor);
    }

    @Override
    public List<Movie> getMoviesByActorId(Long id) {
        return new ArrayList<>(repo.findById(id).orElseThrow().getMovies());
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
