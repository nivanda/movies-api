package net.nivanda.moviesapi.Entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "actor-movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie-id"))
    private Set<Movie> movies;

    public Actor(String name) {
        this.name = name;
    }
}
