package com.remax.repository;

import com.remax.model.ReporteVentasAgenteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // ===========================
    // SP: registrarVenta
    // ===========================
    public String registrarVenta(Integer idPropiedad, Integer idCliente, Integer idAgente, Double monto) {

        StoredProcedureQuery query =
                entityManager.createStoredProcedureQuery("sp_registrarVenta");

        // Parámetros de ENTRADA
        query.registerStoredProcedureParameter("p_id_propiedad", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_cliente", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_agente", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_monto", Double.class, ParameterMode.IN);

        query.setParameter("p_id_propiedad", idPropiedad);
        query.setParameter("p_id_cliente", idCliente);
        query.setParameter("p_id_agente", idAgente);
        query.setParameter("p_monto", monto);

        // Parámetro de MENSAJE (SALIDA)
        query.registerStoredProcedureParameter("p_mensaje", String.class, ParameterMode.OUT);

        query.execute();

        return (String) query.getOutputParameterValue("p_mensaje");
    }

    // ===========================
    // SP: actualizarEstadoVenta
    // ===========================
    public String actualizarEstadoVenta(Integer idVenta, String nuevoEstado) {

        StoredProcedureQuery query =
                entityManager.createStoredProcedureQuery("sp_actualizarEstadoVenta");

        // Parámetros de ENTRADA
        query.registerStoredProcedureParameter("p_id_venta", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_nuevo_estado", String.class, ParameterMode.IN);

        query.setParameter("p_id_venta", idVenta);
        query.setParameter("p_nuevo_estado", nuevoEstado);

        // Parámetro de SALIDA
        query.registerStoredProcedureParameter("p_mensaje", String.class, ParameterMode.OUT);

        query.execute();

        return (String) query.getOutputParameterValue("p_mensaje");
    }

    // ===========================================
    // NUEVO: SP para Reporte de Ventas por Agente
    // Mapea el resultado directamente al DTO
    // ===========================================
    public List<ReporteVentasAgenteDTO> obtenerReporteVentasPorAgente() {
        
        // El segundo parámetro del query es el DTO que se usará para el mapeo
        StoredProcedureQuery query =
                entityManager.createStoredProcedureQuery("sp_generarReporteVentasAgentes", ReporteVentasAgenteDTO.class);

        // Nota: Asumimos que la SP NO tiene parámetros de ENTRADA
        
        // Ejecutar y obtener la lista de resultados mapeados al DTO
        query.execute();
        
        // Obtiene la lista mapeada.
        // Es crucial que los nombres de columnas del ResultSet de la SP coincidan
        // con los campos del constructor de ReporteVentasAgenteDTO.
        @SuppressWarnings("unchecked")
        List<ReporteVentasAgenteDTO> resultado = query.getResultList();
        
        return resultado;
    }
}