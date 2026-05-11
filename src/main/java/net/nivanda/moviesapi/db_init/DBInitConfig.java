package net.nivanda.moviesapi.db_init;

import net.nivanda.moviesapi.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class DBInitConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Bean
    public boolean dbFreshlyCreated(MovieRepository movieRepository) {
        String path = dataSourceUrl.replace("jdbc:sqlite:", "");
        File dbFile = new File(path);

        boolean existed = !dbFile.exists() || movieRepository.count() == 0;
        return existed;
    }
}
