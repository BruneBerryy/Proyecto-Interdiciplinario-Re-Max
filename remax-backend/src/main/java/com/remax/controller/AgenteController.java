package com.remax.controller;

import com.remax.model.Agente;
import com.remax.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgenteController {

    @Autowired
    private AgenteRepository agenteRepository;

    @GetMapping
    public List<Agente> listarAgentes() {
        return agenteRepository.findAll();
    }

    @PostMapping
    public Agente crearAgente(@RequestBody Agente agente) {
        return agenteRepository.save(agente);
    }

    @GetMapping("/{id}")
    public Agente obtenerAgente(@PathVariable Long id) {
        return agenteRepository.findById(id).orElse(null);
    }
}
