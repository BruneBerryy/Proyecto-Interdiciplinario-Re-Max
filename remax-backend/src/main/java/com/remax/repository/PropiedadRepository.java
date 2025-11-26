package com.remax.repository;

import jakarta.persistence.EntityManager;

import jakarta.persistence.ParameterMode;

import jakarta.persistence.PersistenceContext;

import jakarta.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;



@Repository

public class PropiedadRepository { 



    @PersistenceContext

    private EntityManager entityManager;

    

    public String asignarPropiedad(Integer idPropiedad, Integer idAgente) {

        

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_asignarPropiedad");

        

        storedProcedure.registerStoredProcedureParameter("p_id_propiedad", Integer.class, ParameterMode.IN);

        storedProcedure.setParameter("p_id_propiedad", idPropiedad);

        

        storedProcedure.registerStoredProcedureParameter("p_id_agente", Integer.class, ParameterMode.IN);

        storedProcedure.setParameter("p_id_agente", idAgente);

        

        storedProcedure.registerStoredProcedureParameter("p_mensaje", String.class, ParameterMode.OUT);



        storedProcedure.execute();



        return (String) storedProcedure.getOutputParameterValue("p_mensaje");

    }

}