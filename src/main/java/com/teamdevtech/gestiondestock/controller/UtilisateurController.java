package com.teamdevtech.gestiondestock.controller;


import com.teamdevtech.gestiondestock.controller.api.UtilisateurApi;
import com.teamdevtech.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import com.teamdevtech.gestiondestock.dto.UtilisateurDto;
import com.teamdevtech.gestiondestock.services.UtilisateurService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController implements UtilisateurApi {

  private final UtilisateurService utilisateurService;

  public UtilisateurController(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    return utilisateurService.save(dto);
  }

  @Override
  public UtilisateurDto currentUser() {
    return utilisateurService.currentUser();
  }

  @Override
  public UtilisateurDto changePassword(ChangerMotDePasseUtilisateurDto dto) {
    return utilisateurService.changePassword(dto);
  }

  @Override
  public UtilisateurDto findById(Integer id) {
    return utilisateurService.findById(id);
  }

  @Override
  public UtilisateurDto findByEmail(String email) {
    return utilisateurService.findByEmail(email);
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    utilisateurService.delete(id);
  }
}
