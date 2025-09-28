package com.inventario.restinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.restinventario.model.Fornitore;


@Repository
public interface FornitoreRepository extends JpaRepository<Fornitore , Long> {
	
}