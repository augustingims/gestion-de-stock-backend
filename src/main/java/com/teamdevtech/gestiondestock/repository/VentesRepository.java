package com.teamdevtech.gestiondestock.repository;

import java.util.Optional;

import com.teamdevtech.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

  Optional<Ventes> findVentesByCode(String code);
}
