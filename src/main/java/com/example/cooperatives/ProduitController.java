package com.example.cooperatives;

import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitRepo produitRepo;



    @GetMapping("/{id}")
    public Optional<Produit> getproduit(@PathVariable Long id ){
        return produitRepo.findById(id);
    }
    @GetMapping("/all")
    public Iterable<Produit> getAllProduit(){
        return produitRepo.findAll();
    }

    @PostMapping("/add")
    public void addProduit(@RequestBody Produit produit){
        produitRepo.save( produit);

    }

    @GetMapping("/delete/{id}")
    public void deleteProduit(@PathVariable long id){
        produitRepo.deleteAllById(Collections.singleton(id));
    }

    @PostMapping ("/update")
    public void updateProduit(@RequestBody Produit produit){
        produitRepo.save(produit);
    }

}
