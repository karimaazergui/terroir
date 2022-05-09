package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.Secteur;
import com.example.cooperatives.services.ISecteurService;
import com.example.cooperatives.services.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/secteur")
public class SecteurController {
    @Bean
    ISecteurService getSecteur() {
        return new SecteurService();
    }
    @Autowired
    ISecteurService secteurService;

    @GetMapping("/{id}")
    public Optional<Secteur> getSecteur(@PathVariable Long id ){
        return Optional.ofNullable(secteurService.findById(id));
    }
    @GetMapping("/{name}")
    public Optional<Secteur> getSecteurByName(@PathVariable String name ){
        return Optional.ofNullable(secteurService.findByNom(name));
    }


    @GetMapping("/all")
    public Iterable<Secteur> getAllSecteur(){
        return secteurService.findAll();
    }

    @PostMapping("/add")
    public void addSecteur(@RequestBody Secteur secteur){
        secteurService.save( secteur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSecteur(@PathVariable long id){
        secteurService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void updateSecteur(@PathVariable long id,@RequestBody Secteur secteur){
        secteurService.upSecteur(id,secteur);
    }




}
