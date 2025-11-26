package com.remax.service;

import com.remax.repository.VisitaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service

public class VisitaService {


    @Autowired

    private VisitaRepository visitaRepository;
    
    public String programarVisita(Integer idAgente, Integer idCliente, Integer idPropiedad, String fecha) {
    	   
        // VALIDACIÓN DE CAJA BLANCA: Verificamos que los IDs no sean nulos
        if (idAgente == null || idPropiedad == null) {
            return "ERROR: El Agente y la Propiedad son obligatorios para programar la visita.";
        }

        // Aquí iría tu lógica actual (llamada al Repository)
        return visitaRepository.programarVisita(idAgente, idCliente, idPropiedad, fecha);
    }


}