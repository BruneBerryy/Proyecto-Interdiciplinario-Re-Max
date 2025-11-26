package com.remax.service;



import com.remax.repository.PropiedadRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service

public class PropiedadService {

    

    @Autowired

    private PropiedadRepository propiedadRepository;



    public String asignarPropiedadAAgente(Integer idPropiedad, Integer idAgente) {

        

        return propiedadRepository.asignarPropiedad(idPropiedad, idAgente);

    }

}