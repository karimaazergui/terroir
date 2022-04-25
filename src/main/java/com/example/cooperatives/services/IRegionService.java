package com.example.cooperatives.services;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Region;


import java.util.List;

import java.util.Set;

public interface IRegionService {
    public void addRegion(Region region) ;
    public Region getRegion(long code);
    public void addRegion(Region region, Set<Cooperative> listCooperatives) ;

    void addRegion(Region region, MatierePremiere matierePremiereList) ;

    public long saveRegion(Region region);
    public List<Cooperative> getListCooperativesParRegion(Long idregion);

    List<MatierePremiere> getListMatierePremiereParRegion(Long idregion);

    public void updateRegion(Region region);
    public void deleteRegion(Long idregion);
    public Iterable<Region> getAllRegions();
}
