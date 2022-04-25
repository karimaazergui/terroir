package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.Region;
import com.example.cooperatives.services.IMatierePremiereService;
import com.example.cooperatives.services.MatierePremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MatierePremier")
public class MatierePremerController {


    @Autowired
    IMatierePremiereService matierePremiereService;

    @PostMapping("/add")
    public void saveMatierePremier(@RequestBody MatierePremiere matierePremiere) {
        matierePremiereService.saveMatierePremiere(matierePremiere);
    }
    @GetMapping("/{id}")
    public Optional<MatierePremiere> getMatierPremier(@PathVariable Long id) {
        return matierePremiereService.getMatierePremiere(id);
    }
    @GetMapping("/delete/{id}")
    public void deleteMatierPremier(@PathVariable Long id) {
        matierePremiereService.deleteMatierepremiere(id);
    }
    @PostMapping("/update")
    public void updateMatierePremiere(@RequestBody MatierePremiere matierePremiere) {
        matierePremiereService.updateMatierepremiere(matierePremiere);
    }
    @GetMapping("/productOfMatierePremier/{id}")
    public List<Produit> getproductOfMatierePremier(@PathVariable Long id) {
        return matierePremiereService.getListProduitsParMatierePremiere(id);
    }
    @GetMapping("/regionOfMatierePremier/{id}")

    public List<Region> getregionOfMatierePremier(@PathVariable Long id) {
        return matierePremiereService.getListRegionsParMatierePremiere(id);
    }
    @GetMapping("/all")
    public Iterable<MatierePremiere> getAllMatierePremiere() {
        return matierePremiereService.getAllMatierePremiere();
    }

}
