package co.edu.uniquindio.poo.envioproyecto.model;

public class Tarifa {

    private int distancia;
    private int volumen;

    private boolean costoPrioridad;

    public Tarifa(int distancia, int volumen, boolean costoPrioridad) {
        this.distancia = distancia;
        this.volumen = volumen;

        this.costoPrioridad = costoPrioridad;

    }

    public int CalcularCosto(int distancia, int volumen, boolean costoPrioridad) {
        int resultado = 0;
        int costoBase = 100;

        if (distancia > 0 && volumen > 0 && costoBase > 0 && !costoPrioridad) {
            resultado = 100 + distancia * volumen * costoBase;
        } else if (distancia > 0 && volumen > 0 && costoBase > 0 && costoPrioridad) {
            resultado = costoBase * distancia * volumen + 200;
        }

        return resultado;
    }
    }


