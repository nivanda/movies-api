package net.nivanda.moviesapi.repository;

import net.nivanda.moviesapi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
