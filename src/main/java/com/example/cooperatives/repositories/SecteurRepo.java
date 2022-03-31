package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Secteur;
import org.springframework.data.repository.CrudRepository;

public interface SecteurRepo extends CrudRepository<Secteur,Long> {
}
