package com.example;

/**
 * Representa una tableta electrónica.
 */
public class Tablet extends DispositivoTecnologico {

    private double tamanoPantallaPulgadas;
    private boolean tieneLapizDigital;

    public Tablet(String marca, String modelo, double precioBase,
                  int anioFabricacion, double tamanoPantallaPulgadas,
                  boolean tieneLapizDigital) {
        super(marca, modelo, precioBase, anioFabricacion);
        setTamanoPantallaPulgadas(tamanoPantallaPulgadas);
        this.tieneLapizDigital = tieneLapizDigital;
    }

    public double getTamanoPantallaPulgadas() {
        return tamanoPantallaPulgadas;
    }

    public void setTamanoPantallaPulgadas(double tamanoPantallaPulgadas) {
        if (!Double.isFinite(tamanoPantallaPulgadas)
                || tamanoPantallaPulgadas <= 0) {
            throw new IllegalArgumentException("El tamaño de pantalla debe ser mayor que cero.");
        }
        this.tamanoPantallaPulgadas = tamanoPantallaPulgadas;
    }

    public boolean isTieneLapizDigital() {
        return tieneLapizDigital;
    }

    public void setTieneLapizDigital(boolean tieneLapizDigital) {
        this.tieneLapizDigital = tieneLapizDigital;
    }

    /**
     * Las pantallas grandes elevan el costo de revisión y calibración.
     * El lápiz digital añade una comprobación adicional.
     */
    @Override
    public double calcularCostoMantenimiento() {
        double costo = super.calcularCostoMantenimiento();
        costo += tamanoPantallaPulgadas * 2200.0;

        if (tieneLapizDigital) {
            costo += 18000.0;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "TABLET | " + descripcionComun()
                + ", Pantalla: " + tamanoPantallaPulgadas + " pulgadas"
                + ", Lápiz digital: " + (tieneLapizDigital ? "Sí" : "No");
    }
}
