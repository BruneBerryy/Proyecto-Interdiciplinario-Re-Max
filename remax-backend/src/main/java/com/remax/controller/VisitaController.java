// Archivo: VisitaController.java

package com.remax.controller;

import com.remax.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Quitamos el import de VisitaRegistroDTO porque ya no se usa en este método
// import com.remax.model.VisitaRegistroDTO; 
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;


@RestController
@RequestMapping("/api/viewings") 
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    // ANTES: @PostMapping, programarVisita(@RequestBody VisitaRegistroDTO visitaData)
    // AHORA: GET: http://localhost:8080/api/viewings?idAgente=1&idCliente=2&idPropiedad=3&fecha=2026-03-20%2014:00:00
    @GetMapping // <-- CAMBIO DE @PostMapping A @GetMapping
    public ResponseEntity<String> programarVisita(
            @RequestParam Integer idAgente, // <-- Usamos @RequestParam para cada campo
            @RequestParam Integer idCliente,
            @RequestParam Integer idPropiedad,
            @RequestParam String fecha) { // La fecha se pasa como String en la URL

        // Llamada al servicio con los parámetros
        String resultado = visitaService.programarVisita(
                idAgente, 
                idCliente, 
                idPropiedad, 
                fecha
        );

        // Devolvemos el mensaje del SP
        if (resultado.startsWith("ERROR")) {
            return ResponseEntity.badRequest().body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }
}