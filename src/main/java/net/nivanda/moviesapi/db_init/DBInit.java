package net.nivanda.moviesapi.db_init;

import net.nivanda.moviesapi.Entities.Actor;
import net.nivanda.moviesapi.Entities.Genre;
import net.nivanda.moviesapi.Entities.Movie;
import net.nivanda.moviesapi.Repositories.ActorRepository;
import net.nivanda.moviesapi.Repositories.GenreRepository;
import net.nivanda.moviesapi.Repositories.MovieRepository;
import org.aspectj.weaver.ast.And;
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
            System.out.println("Database was freshly created. Inserting sample data...");


            Actor Keanu = new Actor("Keanu Reeves", LocalDate.of(1964, 9, 2));
            Actor Tom = new Actor("Tom Hanks", LocalDate.of(1956, 7, 9));
            Actor Tim = new Actor("Tim Robbins", LocalDate.of(1958, 10, 16));
            Actor Morgan = new Actor("Morgan Freeman", LocalDate.of(1937, 6, 1));
            Actor Ralph = new Actor("Ralph Fiennes", LocalDate.of(1962, 12, 22));
            Actor James = new Actor("James Stewart", LocalDate.of(1908, 5, 20));
            Actor John = new Actor("John Travolta", LocalDate.of(1954, 2, 18));
            Actor Robert = new Actor("Robert De Niro", LocalDate.of(1943, 8, 17));
            Actor Kevin = new Actor("Kevin Spacey", LocalDate.of(1959, 7, 26));
            Actor Edward = new Actor("Edward Norton", LocalDate.of(1969, 8, 18));
            Actor Anthony = new Actor("Anthony Hopkins", LocalDate.of(1937, 12, 31));
            Actor Brad = new Actor("Brad Pitt", LocalDate.of(1963, 12, 18));
            Actor Matt = new Actor("Matt Damon", LocalDate.of(1970, 10, 8));
            Actor Jack = new Actor("Jack Nicholson", LocalDate.of(1937, 4, 22));
            Actor Leonardo = new Actor("Leonardo DiCaprio", LocalDate.of(1974, 11, 11));


            Genre scifi = new Genre("Sci-Fi");
            Genre drama = new Genre("Drama");
            Genre crime = new Genre("Crime");
            Genre thriller = new Genre("Thriller");
            Genre action = new Genre("Action");


            Movie Matrix = new Movie("The Matrix", 1999, 136);
            Movie Gump = new Movie("Forrest Gump", 1994, 142);
            Movie Shawshank = new Movie("The Shawshank Redemption", 1994, 142);
            Movie Schindler = new Movie("Schindler's List", 1993, 195);
            Movie Angry = new Movie("12 Angry Men", 1957, 96);
            Movie Pulp = new Movie("Pulp Fiction", 1994, 154);
            Movie Goodfellas = new Movie("Goodfellas", 1990, 146);
            Movie Lambs = new Movie("The Silence of the Lambs", 1991, 118);
            Movie Fight = new Movie("Fight Club", 1999, 139);
            Movie Se7en = new Movie("Se7en", 1995, 127);
            Movie Shining = new Movie("The Shining", 1980, 146);
            Movie Gladiator = new Movie("Gladiator", 2000, 155);
            Movie Inception = new Movie("Inception", 2010, 148);
            Movie Interstellar = new Movie("Interstellar", 2014, 169);
            Movie Gentlemen = new Movie("The Gentlemen", 2019, 113);
            Movie Catch = new Movie("Catch Me If You Can", 2002, 141);
            Movie Steel = new Movie("Man of Steel", 2013, 143);
            Movie Northwest = new Movie("North by Northwest", 1959, 136);
            Movie Private = new Movie("Saving Private Ryan", 1998, 169);
            Movie Wick = new Movie("John Wick", 2014, 101);


            Matrix.addActor(Keanu);
            Matrix.addGenre(action);
            Matrix.addGenre(scifi);
            movieRepository.save(Matrix);

            Gump.addActor(Tom);
            Gump.addGenre(drama);
            movieRepository.save(Gump);

            Shawshank.addActor(Tim);
            Shawshank.addActor(Morgan);
            Shawshank.addGenre(drama);
            movieRepository.save(Shawshank);

            Schindler.addActor(Ralph);
            Schindler.addGenre(drama);
            movieRepository.save(Schindler);

            Angry.addActor(James);
            Angry.addGenre(drama);
            Angry.addGenre(thriller);
            movieRepository.save(Angry);

            Pulp.addActor(John);
            Pulp.addActor(Brad);
            Pulp.addGenre(drama);
            Pulp.addGenre(crime);
            movieRepository.save(Pulp);

            Goodfellas.addActor(Robert);
            Goodfellas.addGenre(crime);
            Goodfellas.addGenre(drama);
            movieRepository.save(Goodfellas);

            Lambs.addActor(Anthony);
            Lambs.addGenre(crime);
            Lambs.addGenre(thriller);
            movieRepository.save(Lambs);

            Fight.addActor(Edward);
            Fight.addActor(Brad);
            Fight.addGenre(drama);
            Fight.addGenre(thriller);
            movieRepository.save(Fight);

            Se7en.addActor(Kevin);
            Se7en.addActor(Brad);
            Se7en.addGenre(crime);
            Se7en.addGenre(drama);
            Se7en.addGenre(thriller);
            movieRepository.save(Se7en);

            Shining.addActor(Jack);
            Shining.addGenre(drama);
            Shining.addGenre(thriller);
            movieRepository.save(Shining);

            Gladiator.addActor(Matt);
            Gladiator.addGenre(action);
            Gladiator.addGenre(drama);
            movieRepository.save(Gladiator);

            Inception.addActor(Leonardo);
            Inception.addGenre(scifi);
            Inception.addGenre(action);
            Inception.addGenre(thriller);
            movieRepository.save(Inception);

            Interstellar.addActor(Matt);
            Interstellar.addGenre(scifi);
            Interstellar.addGenre(drama);
            movieRepository.save(Interstellar);

            Gentlemen.addActor(Matt);
            Gentlemen.addGenre(crime);
            Gentlemen.addGenre(drama);
            movieRepository.save(Gentlemen);

            Catch.addActor(Leonardo);
            Catch.addActor(Tom);
            Catch.addGenre(crime);
            Catch.addGenre(drama);
            movieRepository.save(Catch);

            Steel.addActor(Robert);
            Steel.addGenre(scifi);
            Steel.addGenre(action);
            movieRepository.save(Steel);

            Northwest.addActor(James);
            Northwest.addGenre(thriller);
            Northwest.addGenre(action);
            movieRepository.save(Northwest);

            Private.addActor(Matt);
            Private.addActor(Tom);
            Private.addGenre(action);
            Private.addGenre(drama);
            movieRepository.save(Private);

            Wick.addActor(Keanu);
            Wick.addGenre(action);
            Wick.addGenre(crime);
            movieRepository.save(Wick);


            genreRepository.save(scifi);
            genreRepository.save(drama);
            genreRepository.save(crime);
            genreRepository.save(thriller);
            genreRepository.save(action);

            actorRepository.save(Keanu);
            actorRepository.save(Tom);
            actorRepository.save(Tim);
            actorRepository.save(Morgan);
            actorRepository.save(Ralph);
            actorRepository.save(James);
            actorRepository.save(John);
            actorRepository.save(Robert);
            actorRepository.save(Kevin);
            actorRepository.save(Edward);
            actorRepository.save(Anthony);
            actorRepository.save(Brad);
            actorRepository.save(Matt);
            actorRepository.save(Jack);
            actorRepository.save(Leonardo);

        }
    }
}
