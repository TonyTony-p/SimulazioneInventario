package com.inventario.restinventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdottoFormDto {

    private Long id;

    @NotBlank(message = "Il nome del prodotto è obbligatorio")
    private String nome;

    @NotNull(message = "La quantità è obbligatoria")
    @Min(value = 0, message = "La quantità non può essere negativa")
    private Integer quantita;
    
    @NotBlank(message  = "La descrizione di un prodotto è  obbligatoria")
    private String descrizione;


	@NotNull(message = "Il fornitore è obbligatorio")
    private Long fornitoreId; 

    

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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
    public String getDescrizione() {
    	return descrizione;
    }
    
    public void setDescrizione(String descrizione) {
    	this.descrizione = descrizione;
    }

    public Long getFornitoreId() {
        return fornitoreId;
    }

    public void setFornitoreId(Long fornitoreId) {
        this.fornitoreId = fornitoreId;
    }
}
