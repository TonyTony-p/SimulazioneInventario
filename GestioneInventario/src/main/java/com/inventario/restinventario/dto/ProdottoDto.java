package com.inventario.restinventario.dto;

public class ProdottoDto {

	
	private Long id;
	private String nome;
	private int quantita;
	private FornitoreDto fornitore;
	
	public ProdottoDto() {}
	
	public ProdottoDto(Long id, String nome, int quantita, FornitoreDto fornitore) {
		this.id = id;
		this.nome = nome;
		this.quantita = quantita;
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

	public FornitoreDto getFornitore() {
		return fornitore;
	}

	public void setFornitore(FornitoreDto fornitore) {
		this.fornitore = fornitore;
	}
	
	
	
}
