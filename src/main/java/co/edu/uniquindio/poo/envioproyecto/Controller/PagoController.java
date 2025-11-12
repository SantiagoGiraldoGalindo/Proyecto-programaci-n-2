package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PagoController {
    private PagoProxy pagoProxy;
    private ObservableList<Pago> listaPagos;

    public PagoController() {
        this.pagoProxy = new PagoProxy();
        this.listaPagos = FXCollections.observableArrayList();
    }

    public String procesarPago(MetodoPago metodo, double monto, String fecha, Usuario usuario) {
        IPagoStrategy estrategia = crearEstrategia(metodo, usuario);
        if (estrategia == null) {
            return "Error: Método no válido.";
        }

        String resultado = pagoProxy.procesarPago(estrategia, monto, fecha);

        if (!resultado.contains("Error")) {
            Pago nuevoPago = new Pago("PAG-" + System.currentTimeMillis(), monto, fecha, resultado);
            listaPagos.add(nuevoPago);
            pagoProxy.resetReintentos();
        }

        return resultado;
    }

    private IPagoStrategy crearEstrategia(MetodoPago metodo, Usuario usuario) {
        String titular = (usuario != null) ? usuario.getNombre() + " " + usuario.getApellido() : "Anónimo";
        switch (metodo) {
            case TARJETA:
                return new PagoTarjeta("1234-5678-9012-3456", "123", titular);
            case TRANSFERENCIA:
                return new PagoTransferencia("001-234567", "Bancolombia", titular);
            case EFECTIVO:
                return new PagoEfectivo("REF-" + System.currentTimeMillis());
            default:
                return null;
        }
    }

    public ObservableList<Pago> getListaPagos() {
        return listaPagos;
    }
}