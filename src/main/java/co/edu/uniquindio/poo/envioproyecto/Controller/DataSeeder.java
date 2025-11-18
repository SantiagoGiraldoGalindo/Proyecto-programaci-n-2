package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.*;

import java.time.LocalDate;

/**
 * Clase auxiliar para poblar la aplicación con datos de ejemplo (datos quemados)
 * que faciliten la navegación y la verificación visual de las distintas vistas.
 */
public class DataSeeder {

    public static void seed() {
       
        RegistroUsuarioController reg = new RegistroUsuarioController();
        reg.RegistrarUsuario("Juan", "Perez", "juan@example.com", "3001112222", "Calle 1, Ciudad A", 101, MetodoPago.TARJETA);
        reg.RegistrarUsuario("Maria", "Gomez", "maria@example.com", "3003334444", "Calle 2, Ciudad B", 102, MetodoPago.TRANSFERENCIA);
        reg.RegistrarUsuario("Carlos", "Lopez", "carlos@example.com", "3005556666", "Calle 3, Ciudad C", 103, MetodoPago.EFECTIVO);

        EmpresaEnvios emp = EmpresaEnvios.getinstancia();
        Repartidor r1 = new Repartidor("Andres", "100200300", 1, "andres@envios.com", Estado.ACTIVO);
        Repartidor r2 = new Repartidor("Luisa", "200300400", 2, "luisa@envios.com", Estado.ACTIVO);
        emp.agregarRepartidor(r1);
        emp.agregarRepartidor(r2);

     
        Envios e1 = new Envios("ENV-001", "Barrio Centro, Ciudad A", 5, "Pequeño", LocalDate.now().minusDays(2).toString());
        e1.setUsuarioId(101);
        e1.setEstadoEnvio(EstadoEnvio.ENTREGADO);

        Envios e2 = new Envios("ENV-002", "Sector Norte, Ciudad B", 12, "Mediano", LocalDate.now().minusDays(5).toString());
        e2.setUsuarioId(102);
        e2.setEstadoEnvio(EstadoEnvio.INCIDENCIA);

        Envios e3 = new Envios("ENV-003", "Urbanizacion Sol, Ciudad C", 2, "Pequeño", LocalDate.now().minusDays(1).toString());
        e3.setUsuarioId(103);
        e3.setEstadoEnvio(EstadoEnvio.ENRUTA);

        Envios e4 = new Envios("ENV-004", "Barrio Centro, Ciudad A", 25, "Grande", LocalDate.now().minusDays(10).toString());
        e4.setUsuarioId(101);
        e4.setEstadoEnvio(EstadoEnvio.PAGADO);

        Envios e5 = new Envios("ENV-005", "Sector Sur, Ciudad B", 8, "Mediano", LocalDate.now().minusDays(7).toString());
        e5.setUsuarioId(102);
        e5.setEstadoEnvio(EstadoEnvio.ENTREGADO);

      
        EnviosService.agregarEnvio(e1);
        EnviosService.agregarEnvio(e2);
        EnviosService.agregarEnvio(e3);
        EnviosService.agregarEnvio(e4);
        EnviosService.agregarEnvio(e5);

        emp.getListEnvios().add(e1);
        emp.getListEnvios().add(e2);
        emp.getListEnvios().add(e3);
        emp.getListEnvios().add(e4);
        emp.getListEnvios().add(e5);
    }
}
