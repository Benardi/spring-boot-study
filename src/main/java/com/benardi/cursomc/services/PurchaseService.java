package com.benardi.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benardi.cursomc.domain.Purchase;
import com.benardi.cursomc.exceptions.ObjectNotFoundException;
import com.benardi.cursomc.repositories.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repo;

	public Purchase find(Integer id) {
		Optional<Purchase> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Purchase.class.getName()));
	}

}
