package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepo extends CrudRepository<Categorie,Long> {
    public Categorie findByLibelle(String s);
}
