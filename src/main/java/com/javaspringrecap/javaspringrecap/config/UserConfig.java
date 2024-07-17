package com.javaspringrecap.javaspringrecap.config;

import com.javaspringrecap.javaspringrecap.model.Movie;
import com.javaspringrecap.javaspringrecap.model.User;
import com.javaspringrecap.javaspringrecap.repository.MovieRepository;
import com.javaspringrecap.javaspringrecap.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository){
        return args -> {
            User user1 = new User(
                    "Yasitha Ranga",
                    "yasitharanga1@gmail.com",
                    "PASSWORD",
                    true
            );
            User user2 = new User(
                    "Yasitha K",
                    "yasitharanga2@gmail.com",
                    "PASSWORD",
                    true
            );
            User user3 = new User(
                    "Yasitha B",
                    "yasitharanga3@gmail.com",
                    "PASSWORD",
                    true
            );

//            repository.saveAll(List.of(user1, user2, user3));
        };
    }
}
