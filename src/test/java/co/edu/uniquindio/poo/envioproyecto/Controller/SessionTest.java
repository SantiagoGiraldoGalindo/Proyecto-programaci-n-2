package co.edu.uniquindio.poo.envioproyecto.Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    @Test
    void setAndClearSession() {
        Session.clear();
        assertNull(Session.getCurrentUserId());
        Session.setCurrentUserId(5);
        assertEquals(5, Session.getCurrentUserId());
        Session.clear();
        assertNull(Session.getCurrentUserId());
    }
}
