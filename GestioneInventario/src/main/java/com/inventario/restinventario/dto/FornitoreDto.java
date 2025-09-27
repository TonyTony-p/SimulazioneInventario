package com.inventario.restinventario.dto;



import java.util.List;

;

public class FornitoreDto {

    private Long id;
    private String nome;
    private String indirizzo;
    private String email;
    private String telefono;
    private List<ProdottoDto> prodotti;

    public FornitoreDto() {
    }

    public FornitoreDto(Long id, String nome, String indirizzo, String email, String telefono) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.telefono = telefono;
        this.prodotti = null;
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
	public List<ProdottoDto> getProdotti() {
		return prodotti;
	}

	public void setCani(List<ProdottoDto> prodotti) {
		this.prodotti = prodotti;
	}
	
	
    
}
