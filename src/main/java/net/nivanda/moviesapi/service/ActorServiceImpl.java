package net.nivanda.moviesapi.service;


import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.repository.ActorRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository repo;

    public ActorServiceImpl(ActorRepository repo) {
        this.repo = repo;
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
    public Actor update(Long id, Actor updated) {
        Actor actor = repo.findById(id).orElseThrow();
        actor.setName(updated.getName());
        actor.setBirthDate(updated.getBirthDate());
        actor.setMovies(updated.getMovies());

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
