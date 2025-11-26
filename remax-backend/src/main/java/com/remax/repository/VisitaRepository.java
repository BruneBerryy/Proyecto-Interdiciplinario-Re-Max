package com.remax.repository;



import jakarta.persistence.EntityManager;

import jakarta.persistence.ParameterMode;

import jakarta.persistence.PersistenceContext;

import jakarta.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;



@Repository

public class VisitaRepository {



    @PersistenceContext

    private EntityManager entityManager;



    public String programarVisita(Integer idAgente, Integer idCliente, Integer idPropiedad, String fecha) {

        

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_programarVisita");

        

        

        storedProcedure.registerStoredProcedureParameter("p_id_agente", Integer.class, ParameterMode.IN);

        storedProcedure.setParameter("p_id_agente", idAgente);

        

        storedProcedure.registerStoredProcedureParameter("p_fecha", String.class, ParameterMode.IN);

        storedProcedure.setParameter("p_fecha", fecha);

        

        

        storedProcedure.registerStoredProcedureParameter("p_mensaje", String.class, ParameterMode.OUT);



        storedProcedure.execute();

        

        return (String) storedProcedure.getOutputParameterValue("p_mensaje");

    }

}