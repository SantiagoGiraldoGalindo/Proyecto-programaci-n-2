package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnviosServiceTest {

    @AfterEach
    void tearDown() {
        // limpiar la lista estática entre pruebas
        EnviosService.listaEnvios.clear();
    }

    @Test
    void addFindDeleteUpdate() {
        Envios e1 = new Envios("A1","X",1,"S","2025-11-17");
        EnviosService.agregarEnvio(e1);
        assertNotNull(EnviosService.buscarPorId("A1"));

        // actualizar
        e1.setDestino("Y");
        assertTrue(EnviosService.actualizarEnvio(e1));
        assertEquals("Y", EnviosService.buscarPorId("A1").getDestino());

        // eliminar
        assertTrue(EnviosService.eliminarEnvio("A1"));
        assertNull(EnviosService.buscarPorId("A1"));
    }

    @Test
    void obtenerEnviosUsuarioFiltersByUser() {
        Envios a = new Envios("A","X",1,"S","2025-11-17");
        a.setUsuarioId(1);
        Envios b = new Envios("B","Y",2,"M","2025-11-17");
        b.setUsuarioId(2);
        EnviosService.agregarEnvio(a);
        EnviosService.agregarEnvio(b);

        var list1 = EnviosService.obtenerEnviosUsuario(1);
        assertEquals(1, list1.size());
        assertEquals("A", list1.get(0).getIdEnvio());
    }
}
