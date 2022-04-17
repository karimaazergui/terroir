package com.example.cooperatives.services;

import com.example.cooperatives.entite.*;
import com.example.cooperatives.repositories.CategorieRepo;
import com.example.cooperatives.repositories.MatierePremiereRepo;
import com.example.cooperatives.repositories.ProduitMatiereAssoRepo;
import com.example.cooperatives.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    CategorieRepo categorieRepo;

    @Autowired
    ProduitMatiereAssoRepo assoRepo;

    @Autowired
    MatierePremiereRepo matierePremiereRepo;

    public Iterable<Produit> findAll(){
        return produitRepo.findAll();
    }

    public Produit findById(Long id){
        return produitRepo.findById(id).get();
    }

    @Override
    public Produit save(Produit product) {
        return produitRepo.save(product);
    }

    @Override
    public Produit upProduct(Long id, Produit product) {
        Produit pr = produitRepo.findById(id).get();
        pr.setPrix(product.getPrix());
        return produitRepo.save(pr);
    }

    @Override
    public void deleteById(Long id) {
        produitRepo.deleteById(id);
    }

    @Override
    public void produitCat(String nomp, String nomc) {
        Produit pr = produitRepo.findByLibelle(nomp);
        Categorie cat = categorieRepo.findByLibelle(nomc);
        pr.addCategorie(cat);
        produitRepo.save(pr);
    }

    @Override
    public void addCategoriToProduit(long id, Categorie... categories) {
        Produit produit = produitRepo.findById(id).get();
        produit.setCategorieList(List.of(categories));
        produitRepo.save(produit);
    }

    @Override
    public void addMatiereToProduit(long id, ProduitMatierePremierAsso... produitMatierePremierAssos) {
        Produit produit = produitRepo.findById(id).get();
        produit.setProduitMatieresPremierAsso(List.of(produitMatierePremierAssos));
        produitRepo.save(produit);

    }

    @Override
    public List<MatierePremiere> getMatiereOfProduit(long id) {
        List<ProduitMatierePremierAsso> assos = produitRepo.findById(id).get().getProduitMatieresPremierAsso();
        List<MatierePremiere> matierePremieres = new ArrayList<>();
        for (ProduitMatierePremierAsso mpa: assos) {
            matierePremieres.add(mpa.getMatierePremiere());
        }
        return matierePremieres;
    }

    @Override
    public List<Categorie> getCategorieOfProduit(long id) {
        Produit produit = produitRepo.findById(id).get();
        return produit.getCategorieList();
    }

    @Override
    public void deleteMetiereFromProduit(long id, long... idms) {
        Produit produit = produitRepo.findById(id).get();

        for (long idm: idms){
            MatierePremiere matierePremiere = matierePremiereRepo.findById(idm).get();
            ProduitMatierePremierAsso asso = assoRepo.findByMatierePremiereAndProduit(matierePremiere,produit);
            assoRepo.delete(asso);
        }


    }


}
