package com.example.cooperatives.services;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Region;
import com.example.cooperatives.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RegionService implements IRegionService {

    @Autowired
    RegionRepo regionRepo;

    @Override
    public Region getRegion(long code) {
        return regionRepo.findByCode(code);

    }

    @Override
    public void addRegion(Region region, Set<Cooperative> listCooperatives)  {

        region.setListCooperatives(listCooperatives);
        regionRepo.save(region);
    }
    @Override
    public void addRegion(Region region, MatierePremiere matierePremiereList) {

        region.setMatierePremiereList(List.of(matierePremiereList));
        regionRepo.save(region);
    }

    @Override
    public long saveRegion(Region region) {
        regionRepo.save(region);
        return  region.getCode();
    }

    @Override
    public List<Cooperative> getListCooperativesParRegion(Long codeRegion) {
        List<Cooperative> cooperativeList;
        Region region= this.getRegion(codeRegion);
        cooperativeList = (List<Cooperative>) region.getListCooperatives();
        return cooperativeList;
    }
    @Override
    public List<MatierePremiere> getListMatierePremiereParRegion(Long codeRegion) {
        List<MatierePremiere> matierePremierelist;
        Region region= this.getRegion(codeRegion);
        matierePremierelist = (List<MatierePremiere>) region.getMatierePremiereList();
        return matierePremierelist;
    }

    @Override
    public void updateRegion(Region region) {
        regionRepo.save(region);
    }

    @Override
    public void deleteRegion(Long codeRegion) {
        regionRepo.deleteById(codeRegion);
    }

    @Override
    public Iterable<Region> getAllRegions() {
        return regionRepo.findAll();
    }

    @Override
    public void addRegion(Region region)  {
        String nom = region.getNom();
        long code =region.getCode();
        Region r = this.getRegion(code);
        regionRepo.save(region);

    }
}
