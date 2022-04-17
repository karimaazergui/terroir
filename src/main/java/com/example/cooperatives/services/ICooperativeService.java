package com.example.cooperatives.services;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.Secteur;

import java.util.List;

public interface ICooperativeService {
    public Cooperative findByNom(String nom);

    public long addCooperative(Cooperative cp, Secteur... listSecteur);
    public long addCooperative(Cooperative cp, Long... ids);
    public List<Long> getListCooperativesParSecteurs(Long... idsecteurs);
    public Cooperative addCooperative(Cooperative cooperative); //throws SecteurDejaExist;
    public List<Cooperative> findAll();
    public Cooperative findById(Long id);
    public Cooperative save(Cooperative cooperative);
    public Cooperative upCooperative(Long id,Cooperative cooperative);
    public void deleteById(Long id);
}
