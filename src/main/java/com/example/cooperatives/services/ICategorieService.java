package com.example.cooperatives.services;

import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Produit;

import java.util.List;
import java.util.Optional;


public interface ICategorieService {

    public void addCategorie(Categorie cat, Produit... listProduit);
    public long saveCategorie(Categorie cat);
    public List<Produit> getListProduitsParCategorie(Long idcat);
    public void updateCategorie(Categorie cat);
    public void deleteCategorie(Long idcat);
    public Iterable<Categorie> getAllCategories();
    public Optional<Categorie> getCategorie(Long idcat);
}
