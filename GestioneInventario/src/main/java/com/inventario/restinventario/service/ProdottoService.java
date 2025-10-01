package com.inventario.restinventario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.dto.ProdottoCreateResponseDto;
import com.inventario.restinventario.dto.ProdottoDto;
import com.inventario.restinventario.dto.ProdottoFormDto;
import com.inventario.restinventario.model.Fornitore;
import com.inventario.restinventario.model.Prodotto;
import com.inventario.restinventario.repository.FornitoreRepository;
import com.inventario.restinventario.repository.ProdottoRepository;

import it.studentiscuolajpa.reststudentiscuola.dto.PageResponse;
import jakarta.validation.Valid;

@Service

public class ProdottoService {

	private final ProdottoRepository prodottoRepo;
	private final FornitoreRepository fornitoreRepo;
	
	public ProdottoService(ProdottoRepository prodottoRepo, FornitoreRepository fornitoreRepo) {
		
		this.prodottoRepo = prodottoRepo;
		this.fornitoreRepo = fornitoreRepo;
	}
	
	
	@Transactional(readOnly = true)
	
	public PageResponse<ProdottoCreateResponseDto> listAll(Pageable pageable){
		Page<Prodotto> page = prodottoRepo.findAll(pageable); 
		Page<ProdottoCreateResponseDto> mapper = page.map(p -> new ProdottoCreateResponseDto(p.getId(),p.getNome(),p.getQuantita(),p.getDescrizione()));
		return PageResponse.from(mapper);
	}	
	

	@Transactional
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
	
	@Transactional
	public Prodotto update(@Valid ProdottoFormDto input) {
	    Long id = input.getId();
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("ID non valido per update");
	    }

	    Prodotto p = prodottoRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato: id=" + id));

	    p.setNome(input.getNome());
	    p.setQuantita(input.getQuantita());
	    p.setDescrizione(input.getDescrizione());

	    
	    if (input.getFornitoreId() != null) {
	        Fornitore fornitore = fornitoreRepo.findById(input.getFornitoreId())
	                .orElseThrow(() -> new IllegalArgumentException("Fornitore non trovato con id=" + input.getFornitoreId()));
	        p.setFornitore(fornitore);
	    }

	    return p;
	}
	
	@Transactional
	public void deleteById(Long id) {
		if(!prodottoRepo.existsById(id)) {
			throw new IllegalArgumentException("Prodotto non trovato con ID: " + id);
		}
		
		prodottoRepo.deleteById(id);
	}

}
