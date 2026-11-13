package com.example;

/**
 * Representa un teléfono inteligente.
 */
public class Smartphone extends DispositivoTecnologico {

    private int capacidadAlmacenamientoGB;
    private int saludBateria;

    public Smartphone(String marca, String modelo, double precioBase,
                      int anioFabricacion, int capacidadAlmacenamientoGB,
                      int saludBateria) {
        super(marca, modelo, precioBase, anioFabricacion);
        setCapacidadAlmacenamientoGB(capacidadAlmacenamientoGB);
        setSaludBateria(saludBateria);
    }

    public int getCapacidadAlmacenamientoGB() {
        return capacidadAlmacenamientoGB;
    }

    public void setCapacidadAlmacenamientoGB(int capacidadAlmacenamientoGB) {
        if (capacidadAlmacenamientoGB <= 0) {
            throw new IllegalArgumentException("El almacenamiento debe ser mayor que cero.");
        }
        this.capacidadAlmacenamientoGB = capacidadAlmacenamientoGB;
    }

    public int getSaludBateria() {
        return saludBateria;
    }

    public void setSaludBateria(int saludBateria) {
        if (saludBateria < 0 || saludBateria > 100) {
            throw new IllegalArgumentException("La salud de batería debe estar entre 0 y 100.");
        }
        this.saludBateria = saludBateria;
    }

    /**
     * Una batería más desgastada incrementa el costo estimado
     * porque puede requerir diagnóstico o reemplazo.
     */
    @Override
    public double calcularCostoMantenimiento() {
        double costo = super.calcularCostoMantenimiento();
        costo += (100 - saludBateria) * 900.0;
        costo += capacidadAlmacenamientoGB * 120.0;
        return costo;
    }

    @Override
    public String toString() {
        return "SMARTPHONE | " + descripcionComun()
                + ", Almacenamiento: " + capacidadAlmacenamientoGB + " GB"
                + ", Salud de batería: " + saludBateria + "%";
    }
}
