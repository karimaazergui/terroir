package com.example.cooperatives.services;

import com.example.cooperatives.entite.Secteur;

import java.util.List;

public interface ISecteurService {
    public Secteur findByNom(String nom);
    public Secteur addSecteur(Secteur secteur); //throws SecteurDejaExist;
    public List<Secteur> findAll();
    public Secteur findById(Long id);
    public Secteur save(Secteur secteur);
    public Secteur upSecteur(Long id,Secteur secteur);
    public void deleteById(Long id);
    public void secteurCat(String nomp,String nomc);
}
