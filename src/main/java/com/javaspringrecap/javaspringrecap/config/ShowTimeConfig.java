package com.javaspringrecap.javaspringrecap.config;

import com.javaspringrecap.javaspringrecap.model.ShowTime;
import com.javaspringrecap.javaspringrecap.repository.ShowTimeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class ShowTimeConfig {
    @Bean
    CommandLineRunner showTimeCommandLineRunner(ShowTimeRepository showTimeRepository){
        return args -> {
            ShowTime show1 = new ShowTime(
                    1L,
                    LocalTime.of(10, 20),
                    15.50
            );

            ShowTime show2 = new ShowTime(
                    2L,
                    LocalTime.of(12, 20),
                    18.50
            );


            ShowTime show3 = new ShowTime(
                    3L,
                    LocalTime.of(13, 20),
                    18.50
            );

            showTimeRepository.saveAll(List.of(show1, show2, show3));
        };
    }
}
