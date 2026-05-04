package net.nivanda.moviesapi.db_init;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements ApplicationRunner {

    private final boolean dbFreshlyCreated;
    private final UserRepository userRepository
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
