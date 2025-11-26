package service.copy;

import com.remax.repository.VisitaRepository;
import com.remax.service.VisitaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// 1. Usa Mockito para crear simulaciones de objetos
@ExtendWith(MockitoExtension.class)
class VisitaServiceTest {
   
    // 2. @Mock: Simula la capa de datos (la BD)
    @Mock
    private VisitaRepository visitaRepository;

    // 3. @InjectMocks: Inyecta el objeto simulado en el Service real que probamos
    @InjectMocks
    private VisitaService visitaService;

    // --- Pruebas de Caja Negra (Verificando la Salida del Sistema) ---
   
    @Test
    void programarVisita_AgenteDisponible_DeberiaDevolverMensajeDeExito() {
        // ARRANGE (Preparar)
        Integer idAgente = 5;
        String fecha = "2026-03-20 14:00:00";
        // Esta es la SALIDA esperada del sistema (simulamos la respuesta del Stored Procedure)
        String mensajeDisponible = "Visita programada correctamente.";

        // MOCKITO (Configurar la Simulación):
        // Decimos: Cuando el Service llame a programarVisita, devuelve el mensaje de éxito.
        // Caja Negra: No nos importa cómo el Repository lo hizo, solo la salida.
        when(visitaRepository.programarVisita(idAgente, 1, 1, fecha))
            .thenReturn(mensajeDisponible);

        // ACT (Ejecutar el método real del Service)
        String resultado = visitaService.programarVisita(idAgente, 1, 1, fecha);

        // ASSERT (Verificar)
        // Usamos JUnit para confirmar que la SALIDA del Service coincide con lo esperado.
        assertEquals(mensajeDisponible, resultado, "El sistema debe indicar que el agente estaba disponible.");}
        
     // --- Prueba de Caja Blanca (Verificando una ruta interna) ---
        
        @Test
        void programarVisita_AgenteNulo_DeberiaDevolverErrorYNoLlamarALaBD() {
            // ARRANGE
            // La entrada es incorrecta: idAgente es NULO
            Integer idAgenteInvalido = null;
            String mensajeEsperado = "ERROR: El Agente y la Propiedad son obligatorios para programar la visita.";

            // ACT (Ejecutar el Service con el ID nulo)
            String resultado = visitaService.programarVisita(idAgenteInvalido, 1, 1, "2026-03-20 14:00:00");

            // ASSERT 1 (Verificación del comportamiento - Caja Blanca)
            // Usamos verify(mock, never()) para asegurar que el código NUNCA llegó al Repository.
            // Esto verifica que el 'if' que añadiste funcionó correctamente.
            verify(visitaRepository, never()).programarVisita(idAgenteInvalido, 1, 1, "2026-03-20 14:00:00");
           
            // ASSERT 2 (Verificación de la salida)
            // Usamos assertEquals para confirmar que el mensaje de error es el correcto.
            assertEquals(mensajeEsperado, resultado, "Debe devolver un mensaje de error de validación.");
    }
}