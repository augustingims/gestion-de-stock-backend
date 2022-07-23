package com.teamdevtech.gestiondestock.services;

import com.teamdevtech.gestiondestock.dto.CategorieDto;

import java.util.List;

public interface CategorieService {

  CategorieDto save(CategorieDto dto);

  CategorieDto findById(Integer id);

  CategorieDto findByCode(String code);

  List<CategorieDto> findAll();

  void delete(Integer id);

}
