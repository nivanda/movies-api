package net.nivanda.moviesapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)

                // make all GET-requests available without authorization
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/**").permitAll()

                        // make all other requests not available without authorization
                        .anyRequest().authenticated())

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
