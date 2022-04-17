package com.example.cooperatives.entite;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
public class CooperativeSecteurAsso {
    @EmbeddedId
    SecteurCooperativeKey id=new SecteurCooperativeKey();
    @ManyToOne(cascade = {CascadeType.ALL } )
    @JsonIgnore
    @MapsId("id_cooperative")
    @JoinColumn(name = "id_cooperative")
    Secteur secteur;



    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL } )
    @MapsId("id_secteur")
    @JoinColumn(name = "id_secteur" )
    Cooperative cooperative;

    public Secteur getSecteur() {
        return secteur;
    }

    public Cooperative getCooperative() {
        return cooperative;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }
}
