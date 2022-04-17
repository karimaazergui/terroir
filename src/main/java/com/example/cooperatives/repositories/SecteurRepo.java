package com.example.cooperatives.repositories;


import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SecteurRepo extends CrudRepository<Secteur,Long> {
    public Secteur findByName(String nom);
    public Secteur save(Secteur mp);
}
