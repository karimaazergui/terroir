package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CooperativeRepo extends JpaRepository<Cooperative,Long> {

    @Query("select c.id_cooperative from Cooperative as c " +
            "inner join c.cooperativeSecteurAsso as csect " +
            "inner join csect.secteur as cs " +
            "on cs.id_secteur = :idsect")
    public List<Long> getCooperatives(@Param("idsect") Long idsect);

    public Cooperative findByNom(String nom);
}
