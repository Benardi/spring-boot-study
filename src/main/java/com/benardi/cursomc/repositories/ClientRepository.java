package com.benardi.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benardi.cursomc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
