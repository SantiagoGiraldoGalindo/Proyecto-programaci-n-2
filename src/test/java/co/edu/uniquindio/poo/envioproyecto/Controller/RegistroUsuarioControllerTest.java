package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroUsuarioControllerTest {

    @AfterEach
    void tearDown() {
        RegistroUsuarioController.usuarios.clear();
    }

    @Test
    void registerAndLookup() {
        RegistroUsuarioController ctrl = new RegistroUsuarioController();
        boolean ok = ctrl.RegistrarUsuario("Pedro","Alvarez","p@mail.com","300", "Calle", 10, MetodoPago.EFECTIVO);
        assertTrue(ok);

        Usuario u = ctrl.buscarUsuarioPorId(10);
        assertNotNull(u);
        assertEquals("Pedro", u.getNombre());

        // duplicate id should not register
        boolean dup = ctrl.RegistrarUsuario("Otro","Uno","o@mail","300","C",10, MetodoPago.TARJETA);
        assertFalse(dup);
    }
}
