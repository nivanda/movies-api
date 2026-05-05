package net.nivanda.moviesapi.Entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int releaseYear;

    private int duration;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();

    public Movie() {}

    public Movie(String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Actor> getActors() {
        return this.actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
