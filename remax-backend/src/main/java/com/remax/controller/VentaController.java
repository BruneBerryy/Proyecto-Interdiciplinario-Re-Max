package com.remax.controller;

import com.remax.model.VentaRegistroDTO;
import com.remax.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // POST → Registrar venta
    // Ahora recibe los datos en el cuerpo JSON (RequestBody) usando el DTO.
    @PostMapping("/register")
    public ResponseEntity<String> registrarVenta(@RequestBody VentaRegistroDTO ventaDTO) {
        try {
            // Llama al servicio con los datos extraídos del DTO
            String resultado = ventaService.registrarVenta(
                    ventaDTO.getIdPropiedad(),
                    ventaDTO.getIdCliente(),
                    ventaDTO.getIdAgente(),
                    ventaDTO.getMonto()
            );

            // La SP devuelve un String, lo usamos para el mensaje de respuesta
            if (resultado != null && resultado.toLowerCase().contains("error")) {
                // Si la SP devuelve un mensaje con la palabra "error", respondemos con 400
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(resultado);
            }

            // Éxito: retorna 200 OK con el mensaje de la SP
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            // Error interno de la aplicación (ej: conexión a DB)
            // Imprimimos la pila del error en consola para depuración
            e.printStackTrace(); 
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: No se pudo conectar o ejecutar la lógica de la venta.");
        }
    }

    // PUT → Actualizar estado de venta
    // EJEMPLO URL: http://localhost:8080/api/sales/1/estado?estado=CANCELADA
    @PutMapping("/{id}/estado")
    public ResponseEntity<String> actualizarEstadoVenta(
            @PathVariable Integer id,
            @RequestParam String estado) {
        try {
            String resultado = ventaService.actualizarEstadoVenta(id, estado);
            
            if (resultado != null && resultado.toLowerCase().contains("error")) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(resultado);
            }

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor al actualizar el estado: " + e.getMessage());
        }
    }
}
