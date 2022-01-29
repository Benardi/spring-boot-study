package com.benardi.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benardi.cursomc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
