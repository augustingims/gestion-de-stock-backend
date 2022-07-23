package com.teamdevtech.gestiondestock.repository;

import com.teamdevtech.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
