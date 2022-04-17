package com.example.cooperatives.services;



import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.ProduitMatierePremierAsso;

import java.util.List;

public interface IProductService {

    public Iterable<Produit> findAll();
    public Produit findById(Long id);
    public Produit save(Produit product);
    public Produit upProduct(Long id,Produit product);
    public void deleteById(Long id);
    public void produitCat(String nomp,String nomc);
    public void addCategoriToProduit(long id, Categorie...categories);
    public void addMatiereToProduit(long id, ProduitMatierePremierAsso...produitMatierePremierAssos);
    public List<MatierePremiere> getMatiereOfProduit(long id);
    public List<Categorie> getCategorieOfProduit(long id);
    public void deleteMetiereFromProduit(long id , long...idms);
}
