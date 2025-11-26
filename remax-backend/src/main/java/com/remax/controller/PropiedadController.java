// Archivo: PropiedadController.java

package com.remax.controller;

import com.remax.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties") 
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    // ANTES: @PostMapping("/assign") 
    // AHORA: GET: http://localhost:8080/api/properties/assign?idPropiedad=1&idAgente=5
    @GetMapping("/assign") // <-- CAMBIO DE @PostMapping A @GetMapping
    public String asignarPropiedad(
            @RequestParam Integer idPropiedad,
            @RequestParam Integer idAgente) {
        
        return propiedadService.asignarPropiedadAAgente(idPropiedad, idAgente);
    }
    
}