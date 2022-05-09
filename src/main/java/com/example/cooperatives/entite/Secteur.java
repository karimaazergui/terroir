package com.example.cooperatives.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secteur")
    private Long id_secteur;
    @Column(name = "name")
    private  String name;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "secteur",
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST})
    Set<CooperativeSecteurAsso> cooperativeSecteurAsso;
    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "cooperativeSecteurAsso",
            joinColumns = @JoinColumn( name = "id_secteur" ),
            inverseJoinColumns = @JoinColumn( name = "id_cooperative" ) )
    List<Cooperative> cooperativeList=new ArrayList<>();

    public Long getId_secteur() {
        return id_secteur;
    }

    public void setId_secteur(Long id_secteur) {
        this.id_secteur = id_secteur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
