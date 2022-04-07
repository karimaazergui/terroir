package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.ProduitMatierePremierAsso;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProduitMatiereAssoRepo extends CrudRepository<ProduitMatierePremierAsso, Long> {
    public Collection<ProduitMatierePremierAsso> findByProduit(Produit produit);

}
