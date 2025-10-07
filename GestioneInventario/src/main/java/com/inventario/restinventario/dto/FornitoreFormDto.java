package com.inventario.restinventario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class FornitoreFormDto {

	private Long id;
	
    @NotBlank(message = "Il nome del fornitore è obbligatorio")
    @Size(max = 100, message = "Il nome del fornitore non può superare i 100 caratteri")
    private String nome;

    @Size(max = 150, message = "L'indirizzo non può superare i 150 caratteri")
    private String indirizzo;

    @Email(message = "L'email non è valida")
    @Size(max = 100, message = "L'email non può superare i 100 caratteri")
    private String email;

    @Size(max = 20, message = "Il numero di telefono non può superare i 20 caratteri")
    private String telefono;

    private List<ProdottoFormDto> prodotti;


    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ProdottoFormDto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoFormDto> prodotti) {
        this.prodotti = prodotti;
    }
}
