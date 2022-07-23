package com.teamdevtech.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity  {

    @Column(name = "code")
    private String code;

    @Column(name = "date_vente")
    private Instant dateVente;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "vente")
    private List<LigneVente> ligneVentes;
}

