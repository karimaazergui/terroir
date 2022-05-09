package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.Secteur;
import com.example.cooperatives.services.ICooperativeService;
import com.example.cooperatives.services.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/cooperative")
public class CooperativeController {
    @Bean
    ICooperativeService getCooperative() {
        return new CooperativeService();
    }
    @Autowired
    ICooperativeService cooperativeService;

    @GetMapping("/{id}")
    public Optional<Cooperative> getCooperative(@PathVariable Long id ){
        return Optional.ofNullable(cooperativeService.findById(id));
    }
    @GetMapping("/{name}")
    public Optional<Cooperative> getCooperativeByName(@PathVariable String name ){
        return Optional.ofNullable(cooperativeService.findByNom(name));
    }


    @GetMapping("/all")
    public Iterable<Cooperative> getAllCooperative(){
        return cooperativeService.findAll();
    }


    @PostMapping("/add")
    public void addCooperative(@RequestBody Cooperative cooperative){
        cooperativeService.addCooperative(cooperative);
    }

    @PostMapping("/addwithSect")
    public void addCooperativeSec(@RequestBody Cooperative cp, @RequestBody Secteur... listSecteur){
        cooperativeService.addCooperative(cp, listSecteur);
    }

    @PostMapping("/addwithSectId")
    public void addCooperativeSecId(@RequestBody Cooperative cp, @RequestBody Long... ids) {
        cooperativeService.addCooperative(cp, ids);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCooperative(@PathVariable long id){
        cooperativeService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void updateCooperative(@PathVariable long id,@RequestBody Cooperative Cooperative){
        cooperativeService.upCooperative(id,Cooperative);
    }

}
