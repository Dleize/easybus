package com.tein8.easybus.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tein8.easybus.model.Role;
import com.tein8.easybus.model.User;
import com.tein8.easybus.model.Onibus;
import com.tein8.easybus.repository.OnibusRepository;
import com.tein8.easybus.repository.UserRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OnibusRepository onibusRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(
            new User()
                .name("Pedro")
                .email("pedro@fiap.com.br")
                .password(passwordEncoder.encode("123"))
                .withRole(new Role("ROLE_USER"))
        );

        userRepository.save(
            new User()
                .name("Admin")
                .email("admin@fiap.com.br")
                .password(passwordEncoder.encode("123")) 
                .withRole(new Role("ROLE_ADMIN"))
        );

        onibusRepository.saveAll(List.of(
            new Onibus("AFZ-7783", 85768, 1, 330110,"Term. São Miguel", "Mercedes", 115, 0, 2, 4, 6, "NaoCheio"),
            new Onibus("AFZ-7790", 85769, 1, 330111,"Term. São Miguel II", "Mercedes", 56, 56, 2, 2, 4, "Cheio")
        ));

    }
    
}
