package com.example.frases.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "frases")
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    @Column(length = 500)
    private String frase;

    public Frase() {}

    public Frase(String autor, String frase) {
        this.autor = autor;
        this.frase = frase;
    }

    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getFrase() {
        return frase;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
