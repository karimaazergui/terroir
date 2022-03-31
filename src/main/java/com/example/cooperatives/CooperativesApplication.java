package com.example.cooperatives;

import com.example.cooperatives.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CooperativesApplication implements CommandLineRunner {

    public static void main(String[] args) {


        SpringApplication.run(CooperativesApplication.class, args);

    }



    @Autowired
    RegionRepo region1;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("walojfzjh");



    }
}
