package com.inventario.restinventario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdottoDto {

	
	private Long id;
	private String nome;
	private int quantita;
	private String descrizione;
	private FornitoreDto fornitore;
	
	public ProdottoDto() {}
	
	public ProdottoDto(Long id, String nome, int quantita,String descrizione, FornitoreDto fornitore) {
		this.id = id;
		this.nome = nome;
		this.quantita = quantita;
		this.descrizione = descrizione;
		this.fornitore = fornitore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public FornitoreDto getFornitore() {
		return fornitore;
	}

	public void setFornitore(FornitoreDto fornitore) {
		this.fornitore = fornitore;
	}
	
	
	
}
