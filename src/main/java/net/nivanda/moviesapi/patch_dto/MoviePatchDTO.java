package net.nivanda.moviesapi.patch_dto;

import java.time.LocalDate;
import java.util.Set;

public class MoviePatchDTO {
    private String title;
    private int releaseYear;
    private int duration;
    private Set<Long> actorIDs;
    private Set<Long> genreIDs;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Long> getActorIDs() {
        return actorIDs;
    }

    public void setActorIDs(Set<Long> actorIDs) {
        this.actorIDs = actorIDs;
    }

    public Set<Long> getGenreIDs() {
        return genreIDs;
    }

    public void setGenreIDs(Set<Long> genreIDs) {
        this.genreIDs = genreIDs;
    }
}
