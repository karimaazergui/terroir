package com.example.cooperatives.services;

import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Produit;
import com.example.cooperatives.entite.Region;

import java.util.List;
import java.util.Optional;

public interface IMatierePremiereService {
    public List<Region>getListRegionsParMatierePremiere(Long idmat);
    public long saveMatierePremiere(MatierePremiere matierePremiere);
    public List<Produit> getListProduitsParMatierePremiere(Long idmat);
    public void updateMatierepremiere(MatierePremiere matierePremiere);
    public void deleteMatierepremiere(Long idmat);
    public Iterable<MatierePremiere> getAllMatierePremiere();
    public Optional<MatierePremiere> getMatierePremiere(Long idmat);




}
