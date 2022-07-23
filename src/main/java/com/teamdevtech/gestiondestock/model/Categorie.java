package com.teamdevtech.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categorie")
public class Categorie extends AbstractEntity  {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categorie")
    private List<Article> articles;
}
