package com.inventario.restinventario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdottoCreateResponseDto {
    private Long id;
    private String nome;
    private int quantita;
    private String descrizione;
    private Long idFornitore;  

    public ProdottoCreateResponseDto(Long id, String nome, int quantita, String descrizione, Long idFornitore) {
        this.id = id;
        this.nome = nome;
        this.quantita = quantita;
        this.descrizione = descrizione;
        this.idFornitore = idFornitore;
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

    public Long getIdFornitore() {
        return idFornitore;
    }
}
