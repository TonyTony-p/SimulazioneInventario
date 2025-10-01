package com.inventario.restinventario.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.dto.FornitoreFormDto;
import com.inventario.restinventario.mappers.DtoMapper;
import com.inventario.restinventario.model.Fornitore;
import com.inventario.restinventario.repository.FornitoreRepository;

import it.studentiscuolajpa.reststudentiscuola.dto.PageResponse;
import jakarta.transaction.Transactional;

@Service
public class FornitoreService {

	@Autowired
	
	private FornitoreRepository fornitoreRepo;
	
	@Transactional
	
    public FornitoreDto create(FornitoreFormDto form) {
        Fornitore f = new Fornitore();
        f.setNome(form.getNome());
        f.setIndirizzo(form.getIndirizzo());
        f.setEmail(form.getEmail());
        f.setTelefono(form.getTelefono());
        return DtoMapper.toFornitoreDto(fornitoreRepo.save(f));
    }
	
	@Transactional
	public PageResponse<FornitoreDto> listAll(Pageable pageable) {
	    Page<Fornitore> page = fornitoreRepo.findAll(pageable);

	    Page<FornitoreDto> mapper = page.map(f -> new FornitoreDto(
	        f.getId(),
	        f.getNome(),
	        f.getIndirizzo(),
	        f.getEmail(),
	        f.getTelefono(),
	        f.getProdotti().stream()
	            .map(DtoMapper::prodottoInFornitore) 
	            .collect(Collectors.toList())
	    ));

	    return PageResponse.from(mapper);
	}

	
}
