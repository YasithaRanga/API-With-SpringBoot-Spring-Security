package com.javaspringrecap.javaspringrecap.config;

import com.javaspringrecap.javaspringrecap.model.Movie;
import com.javaspringrecap.javaspringrecap.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class MovieConfig {
    @Bean
    CommandLineRunner movieCommandLineRunner(MovieRepository repository){
        return args -> {
            Movie movie1 = new Movie(
                    "movie1",
                    "description",
                    "language",
                    "country",
                    true,
                    "genre",
                    LocalDate.of(2024, 4,2),
                    LocalTime.of(10, 20, 30)
            );

            Movie movie2 = new Movie(
                    "movie2",
                    "description2",
                    "language2",
                    "country2",
                    true,
                    "genre2",
                    LocalDate.of(2023, 4,2),
                    LocalTime.of(3, 20, 30)
            );

            Movie movie3 = new Movie(
                    "A Movie",
                    "description2",
                    "language2",
                    "country2",
                    true,
                    "genre2",
                    LocalDate.of(2022, 4,2),
                    LocalTime.of(3, 20, 30)
            );

            repository.saveAll(List.of(movie1, movie2, movie3));
        };
    }
}
