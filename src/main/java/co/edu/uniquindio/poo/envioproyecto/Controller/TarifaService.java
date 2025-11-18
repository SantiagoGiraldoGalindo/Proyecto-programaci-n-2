package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.Tarifa;

/**
 * Servicio simple para calcular tarifas/cotizaciones de envío.
 * Usa reglas heurísticas de demostración (distancia estimada y fórmula básica).
 */
public class TarifaService {

    /**
     * Calcula una cotización simple basada en origen, destino, peso, volumen y prioridad.
     * Distancia se estima: si misma ciudad -> 5, si no -> 50 (valor simple para demo).
     */
    public static double cotizar(String origen, String destino, int peso, int volumen, boolean prioridad) {
        if (volumen <= 0) volumen = 1;
        if (peso < 0) peso = 0;

        int distancia;
        if (origen == null || destino == null) {
            distancia = 50;
        } else if (origen.trim().equalsIgnoreCase(destino.trim())) {
            distancia = 5;
        } else {
            distancia = 50;
        }

        int volumenEfectivo = volumen + Math.max(0, peso / 10);

        Tarifa tarifa = new Tarifa(distancia, volumenEfectivo, prioridad);
        int costo = tarifa.CalcularCosto(distancia, volumenEfectivo, prioridad);

        return (double) costo;
    }
}
