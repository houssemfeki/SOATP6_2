package com.example.tp6;
import com.example.tp6.entities.Compte;
import com.example.tp6.entities.TypeCompte;
import com.example.tp6.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.tp6.repositories")
@EntityScan("com.example.tp6.entities")
@ComponentScan("com.example")
public class Tp6Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp6Application.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPARGNE, Compte.EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPARGNE, Compte.EtatCompte.CREE));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT, Compte.EtatCompte.BLOQUE));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }

}
