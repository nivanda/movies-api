package net.nivanda.moviesapi.repository;

import net.nivanda.moviesapi.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
