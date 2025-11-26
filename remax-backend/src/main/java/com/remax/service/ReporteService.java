package com.remax.service;

import com.remax.model.ReporteVentasAgenteDTO;
import com.remax.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReportRepository reporteRepository;

    public List<ReporteVentasAgenteDTO> getReporteVentasAgente(Integer idAgente) {
        return reporteRepository.reporteVentasAgente(idAgente);
    }

    public List<?> getReporteVentasMensuales() {
        return reporteRepository.reporteVentasMensuales();
    }
}