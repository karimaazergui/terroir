package com.example.cooperatives.services;

import com.example.cooperatives.entite.Cooperative;
import com.example.cooperatives.entite.CooperativeSecteurAsso;
import com.example.cooperatives.entite.Secteur;
import com.example.cooperatives.repositories.CooperativeRepo;
import com.example.cooperatives.repositories.SecteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class CooperativeService implements ICooperativeService {

    @Autowired
    SecteurRepo secteurRepo;

    @Autowired
    CooperativeRepo cooperativeRepo;


    @Override
    public Cooperative findByNom(String nom) {
        return cooperativeRepo.findByNom(nom);
    }
    @Transactional
    public long addCooperative(Cooperative cp, Secteur... listSecteur) {
        for (Secteur sc : listSecteur) {
            CooperativeSecteurAsso ligne = new CooperativeSecteurAsso();
            Secteur mpr = secteurRepo.findByName(sc.getName());
            Collection<CooperativeSecteurAsso> lignes = cp.getCooperativeSecteurAsso();
            if(mpr==null)
            {
                ligne.setSecteur(sc);
                ligne.setCooperative(cp);
                lignes.add(ligne);
            }
            else {
                ligne.setSecteur(mpr);
                ligne.setCooperative(cp);
                lignes.add(ligne);
            }
        }
        cooperativeRepo.save(cp);
        return cp.getId_cooperative();
    }

    @Override
    public long addCooperative(Cooperative cp, Long... ids) {
        for (Long id : ids) {
            CooperativeSecteurAsso ligne = new CooperativeSecteurAsso();
            Secteur mprp = secteurRepo.findById(id).get();
            Secteur mpr = secteurRepo.findByName(mprp.getName());
            Collection<CooperativeSecteurAsso> lignes = cp.getCooperativeSecteurAsso();
            if(mpr==null)
            {
                ligne.setSecteur(mprp);
                ligne.setCooperative(cp);
                lignes.add(ligne);
            }
            else {
                ligne.setSecteur(mpr);
                ligne.setCooperative(cp);
                lignes.add(ligne);
            }
        }
        cooperativeRepo.save(cp);
        return cp.getId_cooperative();
    }

    @Override
    public List<Long> getListCooperativesParSecteurs(Long... idsects) {

        /*List<Long> ids1=cooperativeRepo.getCooperatives(idsects[0])
                .stream()
                .map(cooperative -> cooperative.getId_cooperative())
                .collect(Collectors.toList());

        for(Long idsect : idsects) {
            List<Long >ids = cooperativeRepo.getCooperatives(idsect)
                    .stream()
                    .map(cooperative -> cooperative.getId_cooperative())
                    .collect(Collectors.toList());

            ids1 = ids1.stream()
                    // .distinct()
                    .filter(ids::contains)
                    .collect(Collectors.toList());
        }

        return ids1;*/
        return null;
    }

    @Override
    public Cooperative addCooperative(Cooperative cooperative) {
        return cooperativeRepo.save(cooperative);

    }

    @Override
    public List<Cooperative> findAll() {
        return (List<Cooperative>) cooperativeRepo.findAll();
    }

    @Override
    public Cooperative findById(Long id) {
        return  cooperativeRepo.findById(id).get();
    }

    @Override
    public Cooperative save(Cooperative cooperative) {
        return cooperativeRepo.save(cooperative);    }

    @Override
    public Cooperative upCooperative(Long id, Cooperative cooperative) {
        Cooperative coop = cooperativeRepo.findById(id).get();
        coop.setNom(cooperative.getNom());
        coop.setAddress(cooperative.getAddress());
        coop.setTele(cooperative.getTele());
        return cooperativeRepo.save(coop);    }

    @Override
    public void deleteById(Long id) {
        cooperativeRepo.deleteById(id);
    }


}
