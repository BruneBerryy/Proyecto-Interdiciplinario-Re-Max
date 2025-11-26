package com.remax.repository;

import com.remax.model.ReporteVentasAgenteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Llama al SP: sp_reporteVentasAgente
     * @param idAgente ID del agente a reportar.
     * @return Lista de ReporteVentasAgenteDTO.
     */
    @SuppressWarnings("unchecked")
    public List<ReporteVentasAgenteDTO> reporteVentasAgente(Integer idAgente) {
        
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_reporteVentasAgente");

        storedProcedure.registerStoredProcedureParameter("p_id_agente", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("p_id_agente", idAgente);

        storedProcedure.execute();

        // El resultado del SP es una lista de Object[] que mapeamos al DTO
        List<Object[]> results = storedProcedure.getResultList();

        return results.stream().map(result -> new ReporteVentasAgenteDTO(
        )).collect(Collectors.toList());
    }

    /**
     * Llama al SP: sp_reporteVentasMensuales
     * @return Lista de Object[] con [año, mes, total_ventas_mensuales].
     */
    public List<?> reporteVentasMensuales() {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_reporteVentasMensuales");
        storedProcedure.execute();
        
        // Regresa List<Object[]> donde cada Object[] contiene [Año, Mes, Total Vendido]
        return storedProcedure.getResultList();
    }
}