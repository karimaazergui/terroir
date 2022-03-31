package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Categorie;
import com.example.cooperatives.entite.Cooperative;
import org.springframework.data.repository.CrudRepository;

public interface CooperativeRepo extends CrudRepository<Cooperative,Long> {
}
