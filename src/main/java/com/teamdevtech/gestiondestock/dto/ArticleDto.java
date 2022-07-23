package com.teamdevtech.gestiondestock.dto;

import java.math.BigDecimal;

import com.teamdevtech.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

  private Integer id;

  private String codeArticle;

  private String designation;

  private BigDecimal prixUnitaireHt;

  private BigDecimal tauxTva;

  private BigDecimal prixUnitaireTtc;

  private String photo;

  private CategorieDto categorie;

  private Integer idEntreprise;

  public static ArticleDto fromEntity(Article article) {
    if (article == null) {
      return null;
    }
    return ArticleDto.builder()
        .id(article.getId())
        .codeArticle(article.getCodeArticle())
        .designation(article.getDesignation())
        .photo(article.getPhoto())
        .prixUnitaireHt(article.getPrixUnitaireHt())
        .prixUnitaireTtc(article.getPrixUnitaireTtc())
        .tauxTva(article.getTauxTva())
        .idEntreprise(article.getIdEntreprise())
        .categorie(CategorieDto.fromEntity(article.getCategorie()))
        .build();
  }

  public static Article toEntity(ArticleDto articleDto) {
    if (articleDto == null) {
      return null;
    }
    Article article = new Article();
    article.setId(articleDto.getId());
    article.setCodeArticle(articleDto.getCodeArticle());
    article.setDesignation(articleDto.getDesignation());
    article.setPhoto(articleDto.getPhoto());
    article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
    article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
    article.setTauxTva(articleDto.getTauxTva());
    article.setIdEntreprise(articleDto.getIdEntreprise());
    article.setCategorie(CategorieDto.toEntity(articleDto.getCategorie()));
    return article;
  }

}
