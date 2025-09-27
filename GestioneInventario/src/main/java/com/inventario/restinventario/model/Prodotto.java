package com.inventario.restinventario.model;

import jakarta.persistence.*; 
import java.util.Objects;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Prodotto  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private Integer quantita;

    @ManyToOne(optional = false) // optional=false è obbligatorio avere un fornitore
    @JoinColumn(name = "fornitore_id") // crea la FK "fornitore_id" nella tabella "prodotto" quindi e una chiave di relazione
    private Fornitore fornitore;

   
    public Prodotto() {
    }

    public Prodotto(String nome, int quantita, Fornitore fornitore) {
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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prodotto)) return false;
        Prodotto other = (Prodotto) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
