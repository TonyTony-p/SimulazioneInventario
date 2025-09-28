package com.inventario.restinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.restinventario.model.Prodotto;



@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto , Long> {
	
}
