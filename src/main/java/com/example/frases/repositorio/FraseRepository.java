package com.example.frases.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.frases.modelo.Frase;

public interface FraseRepository extends JpaRepository<Frase, Long> {
}
