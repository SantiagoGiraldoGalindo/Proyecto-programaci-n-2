package co.edu.uniquindio.poo.envioproyecto.Controller;

/**
 * Servicio simple para almacenar la última cotización calculada y el id
 * del envío asociado para el proceso de pago. Útil para pasar información
 * entre pantallas sin persistencia.
 */
public class CotizacionService {
    private static double ultimaCotizacion = 0.0;
    private static String envioIdForPago = null;

    public static void setUltimaCotizacion(double valor) {
        ultimaCotizacion = valor;
    }

    public static double getUltimaCotizacion() {
        return ultimaCotizacion;
    }

    public static void setEnvioIdForPago(String id) { envioIdForPago = id; }
    public static String getEnvioIdForPago() { return envioIdForPago; }
}
