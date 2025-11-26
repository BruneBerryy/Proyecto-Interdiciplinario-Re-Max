package com.remax.service;

import com.remax.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public String registrarVenta(Integer idPropiedad, Integer idCliente, Integer idAgente, Double monto) {
        return ventaRepository.registrarVenta(idPropiedad, idCliente, idAgente, monto);
    }

    public String actualizarEstadoVenta(Integer idVenta, String nuevoEstado) {
        // Normalizamos el estado para evitar errores por minúsculas
        nuevoEstado = nuevoEstado.toUpperCase();
        return ventaRepository.actualizarEstadoVenta(idVenta, nuevoEstado);
    }
}
