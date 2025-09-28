package com.inventario.restinventario.dto;


public class ProdottoCreateResponseDto {
 private Long id;
 private String nome;
 private int quantita;
 private String descrizione;


 public ProdottoCreateResponseDto(Long id, String nome, int quantita, String descrizione) {
     this.id = id;
     this.nome = nome;
     this.quantita = quantita;
     this.descrizione = descrizione;
 }

 public Long getId() {
     return id;
 }

 public String getNome() {
     return nome;
 }

 public int getQuantita() {
     return quantita;
 }

 public String getDescrizione() {
	return descrizione;
 }

}
