package com.inventario.restinventario.model;

import jakarta.persistence.*; 
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "fornitore",
uniqueConstraints = {
  @UniqueConstraint(name = "uk_fornitore_email", columnNames = "email") 
})
@EntityListeners(AuditingEntityListener.class)
public class Fornitore  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 150)
    private String indirizzo;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String telefono;

    
    @OneToMany(mappedBy = "fornitore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prodotto> prodotti;

  
    public Fornitore() {
    }

    public Fornitore(String nome, String indirizzo, String email, String telefono) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.telefono = telefono;
    }

    // Getter e Setter
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

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

 
}
