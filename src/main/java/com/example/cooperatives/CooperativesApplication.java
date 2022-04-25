package com.example.cooperatives;

import com.example.cooperatives.repositories.RegionRepo;
import com.example.cooperatives.services.IMatierePremiereService;
import com.example.cooperatives.services.MatierePremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CooperativesApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(CooperativesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
