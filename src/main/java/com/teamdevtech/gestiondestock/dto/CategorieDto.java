package com.teamdevtech.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import com.teamdevtech.gestiondestock.model.Categorie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDto {

  private Integer id;

  private String code;

  private String designation;

  private Integer idEntreprise;

  @JsonIgnore
  private List<ArticleDto> articles;

  public static CategorieDto fromEntity(Categorie categorie) {
    if (categorie == null) {
      return null;
      // TODO throw an exception
    }

    return CategorieDto.builder()
        .id(categorie.getId())
        .code(categorie.getCode())
        .designation(categorie.getDesignation())
        .idEntreprise(categorie.getIdEntreprise())
        .build();
  }

  public static Categorie toEntity(CategorieDto categoryDto) {
    if (categoryDto == null) {
      return null;
      // TODO throw an exception
    }

    Categorie category = new Categorie();
    category.setId(categoryDto.getId());
    category.setCode(categoryDto.getCode());
    category.setDesignation(categoryDto.getDesignation());
    category.setIdEntreprise(categoryDto.getIdEntreprise());

    return category;
  }
}
