package net.nivanda.moviesapi.patch_dto;

import java.time.LocalDate;
import java.util.Set;

public class ActorPatchDTO {

    private String name;
    private LocalDate birthDate;
    private Set<Long> movieIDs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Long> getMovieIDs() {
        return movieIDs;
    }

    public void setMovieIDs(Set<Long> movieIDs) {
        this.movieIDs = movieIDs;
    }
}
