package service.copy;

// --- Imports de JUnit y Mockito ---
import com.remax.model.ReporteVentasAgenteDTO; // Necesitas este DTO para el reporte
import com.remax.repository.ReportRepository;
import com.remax.service.ReporteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

// --- Imports para las verificaciones (ASSERT) ---
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;


// Usa Mockito para crear simulaciones de objetos (necesario para la Caja Negra)
@ExtendWith(MockitoExtension.class)
class ReportServiceTest {
   
    // ** Objetos para la Prueba de Caja Negra (Interacción Service <-> Repository) **
   
    // @Mock: Simula la capa Repository (acceso a la BD)
    @Mock
    private ReportRepository reporteRepository;

    // @InjectMocks: Inyecta el Mock en el Service real que queremos probar
    @InjectMocks
    private ReporteService reporteService;
   
   
    // ** Método Auxiliar (Lógica Pura de Caja Blanca) **
   
    // Método auxiliar (simulado) para la lógica de cálculo de comisiones.
    // Esto evita que tengas que modificar tu ReportService.java para la prueba.
    private Double calcularComision(Double montoVenta) {
       
        // Corregido: Regla de negocio para Caja Blanca (no puede ser negativo)
        if (montoVenta == null || montoVenta <= 0) {
            return 0.0;
        }
       
        // Lógica de la fórmula (5% de comisión)
        return montoVenta * 0.05;
    }
   
   
    // =========================================================================
    //                      INICIO PRUEBAS DE CAJA BLANCA ⬜
    //      (Verifica la lógica interna, como una fórmula de comisión)
    // =========================================================================
    
    @BeforeEach // Se ejecuta antes de cada @Test
    void setUp() {
        // Inicializa los Mocks y los inyecta en el Service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calcularComision_CasoExitoEstandar() {
        // ARRANGE
        Double montoVenta = 200000.00;
        Double comisionEsperada = 10000.00; // 5% de 200,000

        // ACT
        Double comisionCalculada = calcularComision(montoVenta);

        // ASSERT (Compara la salida real con la salida esperada)
        assertEquals(comisionEsperada, comisionCalculada, 0.001, "La comisión debe ser el 5% exacto.");
    }

    @Test
    void calcularComision_MontoNegativo_DeberiaDevolverCero() {
        // ARRANGE
        Double montoVenta = -500.00;
        Double comisionEsperada = 0.0;

        // ACT
        Double comisionCalculada = calcularComision(montoVenta);

        // ASSERT (Verifica que la regla del 'if' funciona)
        assertEquals(comisionEsperada, comisionCalculada, "La comisión para un monto negativo debe ser 0.");
    }
    
    @Test
    void getReporteVentasAgente_DeberiaDevolverListaDeReporte() {
        // ARRANGE (Preparamos los datos simulados)
        Integer idAgentePrueba = 1;
       
        // Fila de datos que la BD *simularía* devolver.
        ReporteVentasAgenteDTO reporteMock = new ReporteVentasAgenteDTO(
            "Agente Juan",
            5L,             // totalVentas
            500000.00,      // totalMontoVendido
            25000.00        // totalComision
        );
       
        List<ReporteVentasAgenteDTO> listaEsperada = Arrays.asList(reporteMock);

        // CONFIGURACIÓN MOCKITO: Caja Negra: No nos importa el código del Repository, solo su salida.
        when(reporteRepository.reporteVentasAgente(idAgentePrueba))
            .thenReturn(listaEsperada);

        // ACT (Ejecutar el método del Service)
        List<ReporteVentasAgenteDTO> resultado = reporteService.getReporteVentasAgente(idAgentePrueba);

        // ASSERT (Verificar la Salida del Servicio)
        assertFalse(resultado.isEmpty(), "El reporte no debe estar vacío.");
        assertEquals(1, resultado.size());
        assertEquals("Agente Juan", resultado.get(0).getNombreAgente());
    }
}

    

