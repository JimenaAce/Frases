package com.example.frases.controlador;

import org.springframework.web.bind.annotation.*;

import com.example.frases.modelo.Frase;
import com.example.frases.repositorio.FraseRepository;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/frases")
public class FraseController {

    private final FraseRepository repositorio;
    private final Random random = new Random();

    public FraseController(FraseRepository repositorio) {
        this.repositorio = repositorio;
    }

    // Crear frase
    @PostMapping
    public Frase crear(@RequestBody Frase frase) {
        return repositorio.save(frase);
    }

    // Listar todas
    @GetMapping
    public List<Frase> listar() {
        return repositorio.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Frase buscarPorId(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Frase no encontrada"));
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorio.deleteById(id);
    }

    // Frase aleatoria
    @GetMapping("/random")
    public Frase fraseAleatoria() {
        List<Frase> frases = repositorio.findAll();
        if (frases.isEmpty()) {
            throw new RuntimeException("No hay frases registradas");
        }
        return frases.get(random.nextInt(frases.size()));
    }
}
