package com.example.cooperatives.services;



import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.Secteur;

import com.example.cooperatives.repositories.CooperativeRepo;
import com.example.cooperatives.repositories.SecteurRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SecteurService implements ISecteurService  {

    @Autowired
    SecteurRepo secteurRepo ;

    @Autowired
    CooperativeRepo cooperativeRepo;


    @Override
    public Secteur findByNom(String nom) {
        return secteurRepo.findByName(nom);
    }

    @Override
    public Secteur addSecteur(Secteur secteur) {
        return secteurRepo.save(secteur);
    }


    @Override
    public List<Secteur> findAll() {
        return (List<Secteur>) secteurRepo.findAll();
    }

    @Override
    public Secteur findById(Long id) {
        return secteurRepo.findById(id).get();
    }

    @Override
    public Secteur save(Secteur secteur) {
        return secteurRepo.save(secteur);
    }

    @Override
    public Secteur upSecteur(Long id, Secteur secteur) {
        Secteur sc = secteurRepo.findById(id).get();
        sc.setName(secteur.getName());
        return secteurRepo.save(sc);    }

    @Override
    public void deleteById(Long id) {
        secteurRepo.deleteById(id);
    }

    @Override
    public void secteurCat(String noms, String nomc) {
        Secteur sect = secteurRepo.findByName(noms);
        Cooperative coop = cooperativeRepo.findByNom(nomc);
        //sect.setCooperative(coop);
        secteurRepo.save(sect);
    }
}
