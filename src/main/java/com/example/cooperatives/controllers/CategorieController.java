package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.services.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    ICategorieService ICategorieService;

    @GetMapping("/{id}")
    public Optional<Categorie> getCategorie(@PathVariable Long id) {
        return ICategorieService.getCategorie(id);
    }

    @GetMapping("/all")
    public Iterable<Categorie> getAllCategorie() {
        return ICategorieService.getAllCategories();
    }

    @PostMapping("/add")
    public void addCategorie(@RequestBody Categorie cat) {
        ICategorieService.addCategorie(cat);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable long id) {
        ICategorieService.deleteCategorie(id);
    }

    @PostMapping("/update")
    public void updateCategorie(@RequestBody Categorie cat) {
        ICategorieService.updateCategorie(cat);
    }

    @GetMapping("/productOfCategorie/{id}")

    public List<Produit> getProduitParCategorie(@PathVariable Long id) {
        return ICategorieService.getListProduitsParCategorie(id);
    }
}
