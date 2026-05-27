package net.nivanda.moviesapi.patch_dto;

import java.util.Set;

public class GenrePatchDTO {
    private String name;
    private Set<Long> movieIDs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getMovieIDs() {
        return movieIDs;
    }

    public void setMovieIDs(Set<Long> movieIDs) {
        this.movieIDs = movieIDs;
    }
}
