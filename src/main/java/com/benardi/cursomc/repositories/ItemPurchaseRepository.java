package com.benardi.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benardi.cursomc.domain.ItemPurchase;

@Repository
public interface ItemPurchaseRepository extends JpaRepository<ItemPurchase, Integer>{

}
