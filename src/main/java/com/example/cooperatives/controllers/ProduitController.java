package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.ProduitMatierePremierAsso;
import com.example.cooperatives.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {


    @Autowired
    IProductService iProduitService;

    //@Autowired
    //ProduitMatiereAssoRepo assoRepo;

    @GetMapping("/{id}")
    public Produit getproduit(@PathVariable Long id ){
        return iProduitService.findById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public Iterable<Produit> getAllProduit(){
        return iProduitService.findAll();
    }

    @PostMapping("/add")
    public void addProduit(@RequestBody Produit produit){
        iProduitService.save( produit);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduit(@PathVariable long id){

        //produitRepo.deleteAllById(Collections.singleton(id));

        iProduitService.deleteById(id);
    }

    @PostMapping ("/update")
    public void updateProduit(@RequestBody Produit produit){
        iProduitService.save(produit);
    }

    @GetMapping("/{id}/mp")
    public List<MatierePremiere> getMP(@PathVariable long id){
        //return assoRepo.findByProduit(produitRepo.findById(id).get());
        List<ProduitMatierePremierAsso> assos = iProduitService.findById(id).getProduitMatieresPremierAsso();
        //return asso.getMatierePremiere();
        List<MatierePremiere> matierePremieres = new ArrayList<>();
        for (ProduitMatierePremierAsso mpa: assos) {
            matierePremieres.add(mpa.getMatierePremiere());
        }

        return matierePremieres;
    }

    @GetMapping("/test/{id}")
    public void test(@PathVariable long id){
        iProduitService.deleteMetiereFromProduit(id,2);
    }
}
