package com.inventario.restinventario.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.restinventario.dto.ProdottoCreateResponseDto;
import com.inventario.restinventario.dto.ProdottoDto;
import com.inventario.restinventario.dto.ProdottoFormDto;
import com.inventario.restinventario.service.ProdottoService;

import it.studentiscuolajpa.reststudentiscuola.dto.PageResponse;

@RestController
@RequestMapping("api/prodotti")

public class ProdottoController {
	
	@Autowired
	
	private ProdottoService prodottoService;
	
	@GetMapping
	public PageResponse<ProdottoCreateResponseDto> allProdotti(@PageableDefault(size = 10) Pageable pageable){
		return prodottoService.listAll(pageable);
		}
	
	@PostMapping
	public ResponseEntity<ProdottoCreateResponseDto> crea(@RequestBody ProdottoFormDto prodottoDto){
		var created = prodottoService.create(prodottoDto);
		return ResponseEntity.status(201).body(created);
	} 
	
	@PutMapping
	public ResponseEntity<ProdottoDto>update(@RequestBody ProdottoFormDto prodottoDto){
		prodottoService.update(prodottoDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminaProdottobyId(@PathVariable Long id){
		prodottoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
