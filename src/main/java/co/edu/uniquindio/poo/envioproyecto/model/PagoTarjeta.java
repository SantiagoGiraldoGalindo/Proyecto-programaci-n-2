package co.edu.uniquindio.poo.envioproyecto.model;

public class PagoTarjeta implements IPagoStrategy {
    private String numeroTarjeta;
    private String cvv;
    private String nombreTitular;
    
    public PagoTarjeta(String numeroTarjeta, String cvv, String nombreTitular) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.nombreTitular = nombreTitular;
    }
    
    @Override
    public String procesarPago(double monto, String fecha) {
        if (validarTarjeta()) {
            return "Pago con Tarjeta: $" + monto + " procesado exitosamente el " + fecha;
        } else {
            return "Error: Tarjeta inválida";
        }
    }
    
    private boolean validarTarjeta() {
        return numeroTarjeta != null && !numeroTarjeta.isEmpty() &&
               cvv != null && cvv.length() >= 3;
    }
    
    public String getNumerTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumerTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getCvv() {
        return cvv;
    }
    
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
}