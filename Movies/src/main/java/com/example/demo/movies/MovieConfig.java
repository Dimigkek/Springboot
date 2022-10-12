package com.example.demo.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.FEBRUARY;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository){
        return args -> {
            Movie Avatar = new Movie(
                    1L,
                    "Avatar",
                    "Someone",
                    LocalDate.of(2008, FEBRUARY, 4),
                    "Fantasy"
            );
            Movie Ring = new Movie(
                    2L,
                    "Ring",
                    "Chinaman",
                    LocalDate.of(2002, FEBRUARY, 4),
                    "Horror"
            );
            repository.saveAll(
                    List.of(Avatar, Ring)
            );
        };
    }
}
