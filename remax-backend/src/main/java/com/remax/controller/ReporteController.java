package com.remax.controller;

import com.remax.model.ReporteVentasAgenteDTO;
import com.remax.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    /**
     * GET /api/reports/sales-by-agent?idAgente=5
     * Llama a sp_reporteVentasAgente
     */
    @GetMapping("/sales-by-agent")
    public ResponseEntity<List<ReporteVentasAgenteDTO>> getReporteVentasAgente(
            @RequestParam Integer idAgente) {

        List<ReporteVentasAgenteDTO> reporte = reporteService.getReporteVentasAgente(idAgente);

        if (reporte.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reporte);
    }

    /**
     * GET /api/reports/monthly-sales
     * Llama a sp_reporteVentasMensuales
     */
    @GetMapping("/monthly-sales")
    public ResponseEntity<List<?>> getReporteVentasMensuales() {
        List<?> reporte = reporteService.getReporteVentasMensuales();

        if (reporte.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reporte);
    }
}