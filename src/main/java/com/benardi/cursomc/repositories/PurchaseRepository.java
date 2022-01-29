package com.benardi.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benardi.cursomc.domain.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
