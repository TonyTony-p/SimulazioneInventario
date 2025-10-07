package com.inventario.restinventario.mappers;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.dto.ProdottoDto;
import com.inventario.restinventario.model.Fornitore;
import com.inventario.restinventario.model.Prodotto;


public class DtoMapper {
	
	

	//Dto creato per prendere solo i campi del fornitore che reputo necessari
	public static FornitoreDto toFornitoreDto(Fornitore fornitore) {
	    if (fornitore == null) return null;

	    FornitoreDto dto = new FornitoreDto();
	    dto.setId(fornitore.getId());        
	    dto.setNome(fornitore.getNome());
	    dto.setIndirizzo(fornitore.getIndirizzo());
	    dto.setEmail(fornitore.getEmail());
	    dto.setTelefono(fornitore.getTelefono());
	    return dto;
	}
	
	public static FornitoreDto fornitoreNoProduct(Fornitore fornitore) {
		if (fornitore == null) return null;
		
		FornitoreDto dto = new FornitoreDto();
		dto.setId(fornitore.getId());
		dto.setNome(fornitore.getNome());
		dto.setIndirizzo(fornitore.getIndirizzo());
		dto.setEmail(fornitore.getEmail());
		dto.setTelefono(fornitore.getTelefono());
		
		return dto;
	}
	
	
	public static ProdottoDto prodottoInFornitore(Prodotto prodotto) {
		if(prodotto == null) return null;
		
		ProdottoDto dto = new ProdottoDto();
		dto.setId(prodotto.getId());
		dto.setNome(prodotto.getNome());
		dto.setQuantita(prodotto.getQuantita());
		dto.setDescrizione(prodotto.getDescrizione());
		return dto;
	}
	
	
}
