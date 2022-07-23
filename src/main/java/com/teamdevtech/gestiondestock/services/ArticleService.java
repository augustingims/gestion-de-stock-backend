package com.teamdevtech.gestiondestock.services;

import com.teamdevtech.gestiondestock.dto.ArticleDto;
import com.teamdevtech.gestiondestock.dto.LigneCommandeClientDto;
import com.teamdevtech.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.teamdevtech.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);
}
