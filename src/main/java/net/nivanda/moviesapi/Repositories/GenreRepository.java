package net.nivanda.moviesapi.Repositories;

import net.nivanda.moviesapi.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
