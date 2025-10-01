package com.inventario.restinventario.mappers;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.model.Fornitore;

public class DtoMapper {

	//Dto creato per prendere solo i campi del fornitore che reputo necessari
	private FornitoreDto toFornitoreDto(Fornitore fornitore) {
	    if (fornitore == null) return null;

	    FornitoreDto dto = new FornitoreDto();
	    dto.setId(fornitore.getId());        
	    dto.setNome(fornitore.getNome());
	    dto.setEmail(fornitore.getEmail());
	    return dto;
	}
	
}
