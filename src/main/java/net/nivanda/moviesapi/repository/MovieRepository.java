package net.nivanda.moviesapi.repository;

import net.nivanda.moviesapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
