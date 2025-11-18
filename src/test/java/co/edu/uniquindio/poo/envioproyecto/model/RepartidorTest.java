package co.edu.uniquindio.poo.envioproyecto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RepartidorTest {

    @Test
    void constructorAndListEnvios() {
        Repartidor r = new Repartidor("Juan", "1001", 1, "j@mail.com", Estado.ACTIVO);
        assertEquals("Juan", r.getNombre());
        assertEquals("1001", r.getCedula());
        assertEquals(Estado.ACTIVO, r.getEstado());

        Envios e = new Envios("E1","Cali",10,"M","2025-11-17");
        r.getListEnvios().add(e);
        List<Envios> list = r.getListEnvios();
        assertEquals(1, list.size());
        assertEquals(e, list.get(0));

        r.setEstado(Estado.ENRUTA);
        assertEquals(Estado.ENRUTA, r.getEstado());
    }
}
