package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepo extends CrudRepository <Produit,Long> {

    public Produit findByLibelle(String s);
}
