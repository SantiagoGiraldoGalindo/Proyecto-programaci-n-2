package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;

/**
 * Controlador que valida el acceso de repartidores buscando la cédula
 * registrada en {@link EmpresaEnvios}.
 */
public class LoginRepartidorController {


    /** Retorna el repartidor cuya cédula coincide con la clave ingresada. */
    public Repartidor getRepartidorLogueado(String passwordIngresada) {
        for(Repartidor repartidor : EmpresaEnvios.getinstancia().getListRepartidor()){
            if(repartidor.getCedula().equals(passwordIngresada)){
                return repartidor;
            }
        }
        return null;
    }

}
