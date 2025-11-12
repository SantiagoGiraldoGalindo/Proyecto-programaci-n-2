package co.edu.uniquindio.poo.envioproyecto.model;

public class ContextoPago {
    private IPagoStrategy estrategia;
    
    public ContextoPago(IPagoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    /**
     * Ejecuta el pago usando la estrategia seleccionada
     */
    public String ejecutarPago(double monto, String fecha) {
        if (estrategia == null) {
            return "Error: No hay estrategia de pago seleccionada";
        }
        return estrategia.procesarPago(monto, fecha);
    }
    
    /**
     * Cambia la estrategia de pago
     */
    public void setEstrategia(IPagoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    public IPagoStrategy getEstrategia() {
        return estrategia;
    }
}