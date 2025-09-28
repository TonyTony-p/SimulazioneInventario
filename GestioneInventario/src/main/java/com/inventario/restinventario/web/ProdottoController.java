package com.inventario.restinventario.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.restinventario.dto.ProdottoDto;
import com.inventario.restinventario.dto.ProdottoFormDto;
import com.inventario.restinventario.service.ProdottoService;

@RestController
@RequestMapping("api/prodotti")

public class ProdottoController {
	
	@Autowired
	
	private ProdottoService prodottoService;
	
	@PostMapping
	public ResponseEntity<ProdottoDto> crea(@RequestBody ProdottoFormDto prodottoDto){
		var created = prodottoService.create(prodottoDto);
		return ResponseEntity.status(201).body(created);
	} 
	

}
