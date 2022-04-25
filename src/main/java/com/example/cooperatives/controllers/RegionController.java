package com.example.cooperatives.controllers;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.MatierePremiere;
import com.example.cooperatives.entite.Region;
import com.example.cooperatives.services.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    IRegionService regionService;

    @GetMapping("/{id}")
    public Region getRegion(@PathVariable Long id){
        return regionService.getRegion(id);
    }

    @GetMapping("/all")
    public  Iterable<Region> getAllRegion(){
        return regionService.getAllRegions();
    }

    @GetMapping("/delete/{id}")
    public void deleteRegion(@PathVariable long id){
        regionService.deleteRegion(id);
    }

    @PostMapping("/update")
    public void updateRegion(@RequestBody Region cat) {
        regionService.updateRegion(cat);
    }

    @GetMapping("/cooperativesOfRegion/{id}")
    public List<Cooperative> getCooperativesParRegion(@PathVariable Long id) {
        return regionService.getListCooperativesParRegion(id);
    }

    @GetMapping("/matieresPremieresOfRegion/{id}")
    public List<MatierePremiere> getMatieresPremieresParRegion(@PathVariable Long id) {
        return regionService.getListMatierePremiereParRegion(id);
    }

    @PostMapping("/add")
    public void addRegion(@RequestBody Region region){
        regionService.addRegion(region);
    }
}

