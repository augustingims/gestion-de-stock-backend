package com.teamdevtech.gestiondestock.controller.api;

import static com.teamdevtech.gestiondestock.utils.Constants.APP_ROOT;

import com.teamdevtech.gestiondestock.dto.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("categories")
public interface CategorieApi {

  @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Enregistrer une categorie", notes = "Cette methode permet d'enregistrer ou modifier une categorie", response =
      CategorieDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "L'objet category cree / modifie"),
      @ApiResponse(code = 400, message = "L'objet category n'est pas valide")
  })
  CategorieDto save(@RequestBody CategorieDto dto);

  @GetMapping(value = APP_ROOT + "/categories/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Rechercher une categorie par ID", notes = "Cette methode permet de chercher une categorie par son ID", response =
      CategorieDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "La categorie a ete trouve dans la BDD"),
      @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BDD avec l'ID fourni")
  })
  CategorieDto findById(@PathVariable("idCategorie") Integer idCategorie);

  @GetMapping(value = APP_ROOT + "/categories/filter/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Rechercher une categorie par CODE", notes = "Cette methode permet de chercher une categorie par son CODE", response =
      CategorieDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
      @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
  })
  CategorieDto findByCode(@PathVariable("codeCategorie") String codeCategorie);

  @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Renvoi la liste des categories", notes = "Cette methode permet de chercher et renvoyer la liste des categories qui existent "
      + "dans la BDD", responseContainer = "List<CategorieDto>")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
  })
  List<CategorieDto> findAll();

  @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategorie}")
  @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer une categorie par ID")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "La categorie a ete supprime")
  })
  void delete(@PathVariable("idCategorie") Integer id);

}
