package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepo extends CrudRepository<Region,Long> {
    public Region findByCode(long l);
}
