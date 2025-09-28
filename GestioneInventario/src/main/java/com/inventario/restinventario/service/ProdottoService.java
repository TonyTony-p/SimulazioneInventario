package com.inventario.restinventario.service;

import org.springframework.stereotype.Service;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.dto.ProdottoCreateResponseDto;
import com.inventario.restinventario.dto.ProdottoDto;
import com.inventario.restinventario.dto.ProdottoFormDto;
import com.inventario.restinventario.model.Fornitore;
import com.inventario.restinventario.model.Prodotto;
import com.inventario.restinventario.repository.FornitoreRepository;
import com.inventario.restinventario.repository.ProdottoRepository;

@Service

public class ProdottoService {

	private final ProdottoRepository prodottoRepo;
	private final FornitoreRepository fornitoreRepo;
	
	public ProdottoService(ProdottoRepository prodottoRepo, FornitoreRepository fornitoreRepo) {
		
		this.prodottoRepo = prodottoRepo;
		this.fornitoreRepo = fornitoreRepo;
	}
	
	//Dto creato per prendere solo i campi del fornitore che reputo necessari
	private FornitoreDto toFornitoreDto(Fornitore fornitore) {
	    if (fornitore == null) return null;

	    FornitoreDto dto = new FornitoreDto();
	    dto.setId(fornitore.getId());        
	    dto.setNome(fornitore.getNome());
	    dto.setEmail(fornitore.getEmail());
	    return dto;
	}
	
	


	public ProdottoCreateResponseDto create(ProdottoFormDto dto) {
	    if (dto.getId() != null) {
	        throw new IllegalArgumentException("id non valido per la creazione");
	    }

	    // Recupero del fornitore tramite ID
	    if (dto.getFornitoreId() == null) {
	        throw new IllegalArgumentException("ID fornitore obbligatorio");
	    }

	    Fornitore fornitore = fornitoreRepo.findById(dto.getFornitoreId())
	        .orElseThrow(() -> new IllegalArgumentException("Fornitore non trovato"));


	    // Creazione e salvataggio del Prodotto
	    Prodotto prodotto = new Prodotto(dto.getNome(), dto.getQuantita(),dto.getDescrizione(),fornitore);
	    prodotto = prodottoRepo.save(prodotto);

	    
	    return new ProdottoCreateResponseDto(
	        prodotto.getId(),
	        prodotto.getNome(),
	        prodotto.getQuantita(),
	        prodotto.getDescrizione()
	   );
	}

	

	

}
