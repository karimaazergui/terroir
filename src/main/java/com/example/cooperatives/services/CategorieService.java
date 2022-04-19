package com.example.cooperatives.services;


import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.repositories.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService implements ICategorieService {

   @Autowired
   CategorieRepo categorieRepo;


   @Override
   public void addCategorie(Categorie cat, Produit... listProduit) {

      cat.setProduitList(List.of(listProduit));
      categorieRepo.save(cat);

   }

   @Override
   public long saveCategorie(Categorie cat) {
      categorieRepo.save(cat);
      return  cat.getId_categorie();
   }

   @Override
   public List<Produit> getListProduitsParCategorie(Long idcat) {
       List<Produit> produitList;
      Optional<Categorie> categorie=categorieRepo.findById(idcat);
      produitList=categorie.get().getProduitList();
      return produitList;
   }

   @Override
   public void updateCategorie(Categorie cat) {
      categorieRepo.save(cat);
   }

   @Override
   public void deleteCategorie(Long idcat) {
       categorieRepo.deleteById(idcat);
   }

   @Override
   public Iterable<Categorie> getAllCategories() {
      return categorieRepo.findAll();
   }

   @Override
   public Optional<Categorie> getCategorie(Long idcat) {
      return categorieRepo.findById(idcat);
   }
}
