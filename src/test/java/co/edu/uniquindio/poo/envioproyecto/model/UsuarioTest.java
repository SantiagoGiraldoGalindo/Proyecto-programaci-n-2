package co.edu.uniquindio.poo.envioproyecto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void constructorAndGettersSetters() {
        MetodoPago mp = MetodoPago.TARJETA;
        Usuario u = new Usuario("Ana", "Perez", "ana@mail.com", "3001112222", "Calle 1", 42, mp);

        assertEquals("Ana", u.getNombre());
        assertEquals("Perez", u.getApellido());
        assertEquals("ana@mail.com", u.getCorreo());
        assertEquals(42, u.getIdUsuario());
        assertEquals(mp, u.getMetodoPago());

        u.setNombre("María");
        u.setIdUsuario(99);
        assertEquals("María", u.getNombre());
        assertEquals(99, u.getIdUsuario());
    }
}
