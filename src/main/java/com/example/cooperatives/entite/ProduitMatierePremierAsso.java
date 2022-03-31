package com.example.cooperatives.entite;



import javax.persistence.*;

@Entity
public class ProduitMatierePremierAsso {
    @EmbeddedId
    ProduitMatierePremierKey id=new ProduitMatierePremierKey();
    @ManyToOne(cascade = {CascadeType.ALL

    })
    @MapsId("idProduit")
    @JoinColumn(name = "reference_produit")
      Produit produit;


    @ManyToOne(cascade = {CascadeType.ALL })
    @MapsId("idMatierePremiere")
    @JoinColumn(name = "reference_matiere" )
    MatierePremiere matierePremiere;



    private int quantite;




}
