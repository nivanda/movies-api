package net.nivanda.moviesapi.Repositories;

import net.nivanda.moviesapi.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
