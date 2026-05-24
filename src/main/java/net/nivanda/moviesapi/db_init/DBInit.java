package net.nivanda.moviesapi.db_init;

import net.nivanda.moviesapi.entity.Actor;
import net.nivanda.moviesapi.entity.Genre;
import net.nivanda.moviesapi.entity.Movie;
import net.nivanda.moviesapi.repository.ActorRepository;
import net.nivanda.moviesapi.repository.GenreRepository;
import net.nivanda.moviesapi.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBInit implements ApplicationRunner {

    private final boolean dbFreshlyCreated;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;

    public DBInit(boolean dbFreshlyCreated, ActorRepository actorRepository, GenreRepository genreRepository, MovieRepository movieRepository) {
        this.dbFreshlyCreated = dbFreshlyCreated;
        this.actorRepository = actorRepository;
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (dbFreshlyCreated) {
            System.out.println("\u001b[36m" + "Database was freshly created. Inserting sample data...");


            Actor Keanu = actorRepository.save(new Actor("Keanu Reeves", LocalDate.of(1964, 9, 2)));
            Actor Tom = actorRepository.save(new Actor("Tom Hanks", LocalDate.of(1956, 7, 9)));
            Actor Tim = actorRepository.save(new Actor("Tim Robbins", LocalDate.of(1958, 10, 16)));
            Actor Morgan = actorRepository.save(new Actor("Morgan Freeman", LocalDate.of(1937, 6, 1)));
            Actor Ralph = actorRepository.save(new Actor("Ralph Fiennes", LocalDate.of(1962, 12, 22)));
            Actor James = actorRepository.save(new Actor("James Stewart", LocalDate.of(1908, 5, 20)));
            Actor John = actorRepository.save(new Actor("John Travolta", LocalDate.of(1954, 2, 18)));
            Actor Robert = actorRepository.save(new Actor("Robert De Niro", LocalDate.of(1943, 8, 17)));
            Actor Kevin = actorRepository.save(new Actor("Kevin Spacey", LocalDate.of(1959, 7, 26)));
            Actor Edward = actorRepository.save(new Actor("Edward Norton", LocalDate.of(1969, 8, 18)));
            Actor Anthony = actorRepository.save(new Actor("Anthony Hopkins", LocalDate.of(1937, 12, 31)));
            Actor Brad = actorRepository.save(new Actor("Brad Pitt", LocalDate.of(1963, 12, 18)));
            Actor Matt = actorRepository.save(new Actor("Matt Damon", LocalDate.of(1970, 10, 8)));
            Actor Jack = actorRepository.save(new Actor("Jack Nicholson", LocalDate.of(1937, 4, 22)));
            Actor Leonardo = actorRepository.save(new Actor("Leonardo DiCaprio", LocalDate.of(1974, 11, 11)));

            Genre scifi = genreRepository.save(new Genre("Sci-Fi"));
            Genre drama = genreRepository.save(new Genre("Drama"));
            Genre crime = genreRepository.save(new Genre("Crime"));
            Genre thriller = genreRepository.save(new Genre("Thriller"));
            Genre action = genreRepository.save(new Genre("Action"));

            Movie Matrix = new Movie("The Matrix", 1999, 136);
            Matrix.addActor(Keanu);
            Matrix.addGenre(action);
            Matrix.addGenre(scifi);
            movieRepository.save(Matrix);

            Movie Gump = new Movie("Forrest Gump", 1994, 142);
            Gump.addActor(Tom);
            Gump.addGenre(drama);
            movieRepository.save(Gump);

            Movie Shawshank = new Movie("The Shawshank Redemption", 1994, 142);
            Shawshank.addActor(Tim);
            Shawshank.addActor(Morgan);
            Shawshank.addGenre(drama);
            movieRepository.save(Shawshank);

            Movie Schindler = new Movie("Schindler's List", 1993, 195);
            Schindler.addActor(Ralph);
            Schindler.addGenre(drama);
            movieRepository.save(Schindler);

            Movie Angry = new Movie("12 Angry Men", 1957, 96);
            Angry.addActor(James);
            Angry.addGenre(drama);
            Angry.addGenre(thriller);
            movieRepository.save(Angry);

            Movie Pulp = new Movie("Pulp Fiction", 1994, 154);
            Pulp.addActor(John);
            Pulp.addActor(Brad);
            Pulp.addGenre(drama);
            Pulp.addGenre(crime);
            movieRepository.save(Pulp);

            Movie Goodfellas = new Movie("Goodfellas", 1990, 146);
            Goodfellas.addActor(Robert);
            Goodfellas.addGenre(crime);
            Goodfellas.addGenre(drama);
            movieRepository.save(Goodfellas);

            Movie Lambs = new Movie("The Silence of the Lambs", 1991, 118);
            Lambs.addActor(Anthony);
            Lambs.addGenre(crime);
            Lambs.addGenre(thriller);
            movieRepository.save(Lambs);

            Movie Fight = new Movie("Fight Club", 1999, 139);
            Fight.addActor(Edward);
            Fight.addActor(Brad);
            Fight.addGenre(drama);
            Fight.addGenre(thriller);
            movieRepository.save(Fight);

            Movie Se7en = new Movie("Se7en", 1995, 127);
            Se7en.addActor(Kevin);
            Se7en.addActor(Brad);
            Se7en.addGenre(crime);
            Se7en.addGenre(drama);
            Se7en.addGenre(thriller);
            movieRepository.save(Se7en);

            Movie Shining = new Movie("The Shining", 1980, 146);
            Shining.addActor(Jack);
            Shining.addGenre(drama);
            Shining.addGenre(thriller);
            movieRepository.save(Shining);

            Movie Gladiator = new Movie("Gladiator", 2000, 155);
            Gladiator.addActor(Matt);
            Gladiator.addGenre(action);
            Gladiator.addGenre(drama);
            movieRepository.save(Gladiator);

            Movie Inception = new Movie("Inception", 2010, 148);
            Inception.addActor(Leonardo);
            Inception.addGenre(scifi);
            Inception.addGenre(action);
            Inception.addGenre(thriller);
            movieRepository.save(Inception);

            Movie Interstellar = new Movie("Interstellar", 2014, 169);
            Interstellar.addActor(Matt);
            Interstellar.addGenre(scifi);
            Interstellar.addGenre(drama);
            movieRepository.save(Interstellar);

            Movie Gentlemen = new Movie("The Gentlemen", 2019, 113);
            Gentlemen.addActor(Matt);
            Gentlemen.addGenre(crime);
            Gentlemen.addGenre(drama);
            movieRepository.save(Gentlemen);

            Movie Catch = new Movie("Catch Me If You Can", 2002, 141);
            Catch.addActor(Leonardo);
            Catch.addActor(Tom);
            Catch.addGenre(crime);
            Catch.addGenre(drama);
            movieRepository.save(Catch);

            Movie Steel = new Movie("Man of Steel", 2013, 143);
            Steel.addActor(Robert);
            Steel.addGenre(scifi);
            Steel.addGenre(action);
            movieRepository.save(Steel);

            Movie Northwest = new Movie("North by Northwest", 1959, 136);
            Northwest.addActor(James);
            Northwest.addGenre(thriller);
            Northwest.addGenre(action);
            movieRepository.save(Northwest);

            Movie Private = new Movie("Saving Private Ryan", 1998, 169);
            Private.addActor(Matt);
            Private.addActor(Tom);
            Private.addGenre(action);
            Private.addGenre(drama);
            movieRepository.save(Private);

            Movie Wick = new Movie("John Wick", 2014, 101);
            Wick.addActor(Keanu);
            Wick.addGenre(action);
            Wick.addGenre(crime);
            movieRepository.save(Wick);
        }
    }
}
