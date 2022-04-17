package com.example.cooperatives.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SecteurCooperativeKey implements Serializable {
    @Column(name = "id_cooperative")
    Long id_cooperative;

    @Column(name = "id_secteur")
    Long id_secteur;

}