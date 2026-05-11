package net.nivanda.moviesapi.Repositories;

import net.nivanda.moviesapi.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
