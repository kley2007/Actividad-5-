package com.example;

/**
 * Representa un computador de escritorio o portátil.
 */
public class Computador extends DispositivoTecnologico {

    private int memoriaRamGB;
    private boolean tieneTarjetaGrafica;

    public Computador(String marca, String modelo, double precioBase,
                      int anioFabricacion, int memoriaRamGB,
                      boolean tieneTarjetaGrafica) {
        super(marca, modelo, precioBase, anioFabricacion);
        setMemoriaRamGB(memoriaRamGB);
        this.tieneTarjetaGrafica = tieneTarjetaGrafica;
    }

    public int getMemoriaRamGB() {
        return memoriaRamGB;
    }

    public void setMemoriaRamGB(int memoriaRamGB) {
        if (memoriaRamGB <= 0) {
            throw new IllegalArgumentException("La memoria RAM debe ser mayor que cero.");
        }
        this.memoriaRamGB = memoriaRamGB;
    }

    public boolean isTieneTarjetaGrafica() {
        return tieneTarjetaGrafica;
    }

    public void setTieneTarjetaGrafica(boolean tieneTarjetaGrafica) {
        this.tieneTarjetaGrafica = tieneTarjetaGrafica;
    }

    /**
     * Los computadores con más RAM y tarjeta gráfica requieren
     * una revisión técnica más especializada.
     */
    @Override
    public double calcularCostoMantenimiento() {
        double costo = super.calcularCostoMantenimiento();
        costo += memoriaRamGB * 1800.0;

        if (tieneTarjetaGrafica) {
            costo += 35000.0;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "COMPUTADOR | " + descripcionComun()
                + ", RAM: " + memoriaRamGB + " GB"
                + ", Tarjeta gráfica: " + (tieneTarjetaGrafica ? "Sí" : "No");
    }
}
