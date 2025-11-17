package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;

public class LoginRepartidorController {


    public Repartidor getRepartidorLogueado(String passwordIngresada) {
        for(Repartidor repartidor : EmpresaEnvios.getinstancia().getListRepartidor()){
            if(repartidor.getCedula().equals(passwordIngresada)){
                return repartidor;
            }
        }
        return null;
    }

}
