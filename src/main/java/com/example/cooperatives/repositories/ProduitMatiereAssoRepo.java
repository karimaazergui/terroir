package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.ProduitMatierePremierAsso;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ProduitMatiereAssoRepo extends CrudRepository<ProduitMatierePremierAsso, Long> {
    public Collection<ProduitMatierePremierAsso> findByProduit(Produit produit);
    public ProduitMatierePremierAsso findByMatierePremiereAndProduit(MatierePremiere matierePremiere, Produit produit);

}
