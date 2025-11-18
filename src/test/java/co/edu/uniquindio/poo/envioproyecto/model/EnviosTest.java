package co.edu.uniquindio.poo.envioproyecto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnviosTest {

    private Envios envio;

    @BeforeEach
    void setUp() {
        envio = new Envios("E1", "Bogota", 5, "S", "2025-11-17");
    }

    @Test
    void stateTransitions() {
        // Test entregar from enCamino
        envio.enCamino();
        assertEquals(EstadoEnvio.ENRUTA, envio.getEstado());
        envio.entregar();
        assertEquals(EstadoEnvio.ENTREGADO, envio.getEstado());

        // New envio for fallar test: fallar from enCamino should lead to INCIDENCIA
        Envios envio2 = new Envios("E2", "Medellin", 2, "S", "2025-11-17");
        envio2.enCamino();
        envio2.fallar();
        assertEquals(EstadoEnvio.INCIDENCIA, envio2.getEstado());

        // New envio for pagar test
        Envios envio3 = new Envios("E3", "Cali", 3, "M", "2025-11-17");
        envio3.pagar();
        assertEquals(EstadoEnvio.PAGADO, envio3.getEstado());
    }

    @Test
    void usuarioIdSetterGetter() {
        assertNull(envio.getUsuarioId());
        envio.setUsuarioId(7);
        assertEquals(7, envio.getUsuarioId());
    }
}
