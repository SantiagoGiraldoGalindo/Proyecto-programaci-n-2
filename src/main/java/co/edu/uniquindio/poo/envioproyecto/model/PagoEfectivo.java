package co.edu.uniquindio.poo.envioproyecto.model;

public class PagoEfectivo implements IPagoStrategy {
    private String referencia;
    
    public PagoEfectivo(String referencia) {
        this.referencia = referencia;
    }
    
    @Override
    public String procesarPago(double monto, String fecha) {
        if (validarEfectivo()) {
            return "Pago en Efectivo: $" + monto + " recibido el " + fecha + 
                   " con referencia: " + referencia;
        } else {
            return "Error: Pago en efectivo inválido";
        }
    }
    
    private boolean validarEfectivo() {
        return referencia != null && !referencia.isEmpty();
    }
    
    public String getReferencia() {
        return referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}