package com.javaspringrecap.javaspringrecap.config;

import com.javaspringrecap.javaspringrecap.model.ERole;
import com.javaspringrecap.javaspringrecap.model.Role;
import com.javaspringrecap.javaspringrecap.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {
    @Bean
    CommandLineRunner roleCommandLineRunner(RoleRepository repository){
        return args -> {
            if(repository.findByName(ERole.ROLE_USER).isEmpty()) repository.save(new Role(ERole.ROLE_USER));
            if(repository.findByName(ERole.ROLE_ADMIN).isEmpty()) repository.save(new Role(ERole.ROLE_ADMIN));
        };
    }
}
