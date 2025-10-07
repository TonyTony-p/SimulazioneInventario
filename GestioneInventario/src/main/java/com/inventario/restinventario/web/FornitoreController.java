package com.inventario.restinventario.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.restinventario.dto.FornitoreDto;
import com.inventario.restinventario.dto.FornitoreFormDto;
import com.inventario.restinventario.service.FornitoreService;

import it.studentiscuolajpa.reststudentiscuola.dto.PageResponse;

@RestController
@RequestMapping("/api/fornitori")

public class FornitoreController {

	@Autowired
	private FornitoreService fornitoreService;
	
	@GetMapping
	public PageResponse<FornitoreDto> allFornitori(@PageableDefault(size = 10) Pageable pageable){
		return fornitoreService.listAll(pageable);
	}
	
	@PostMapping
	public ResponseEntity<FornitoreDto> crea(@RequestBody FornitoreFormDto fornitoreDto){
		var created = fornitoreService.create(fornitoreDto);
		return ResponseEntity.status(201).body(created);
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminaFornitoreById(@PathVariable Long id) {
	    fornitoreService.deleteById(id);
	    return ResponseEntity.noContent().build();
	}

	
	
}
