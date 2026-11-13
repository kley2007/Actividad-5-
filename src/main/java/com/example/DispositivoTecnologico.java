package com.example;

/**
 * Clase padre que representa un dispositivo tecnológico.
 * Contiene los datos y comportamientos comunes de los equipos.
 */
public class DispositivoTecnologico {

    private String marca;
    private String modelo;
    private double precioBase;
    private int anioFabricacion;

    /**
     * Constructor parametrizado. Valida los datos recibidos.
     */
    public DispositivoTecnologico(String marca, String modelo,
                                  double precioBase, int anioFabricacion) {
        setMarca(marca);
        setModelo(modelo);
        setPrecioBase(precioBase);
        setAnioFabricacion(anioFabricacion);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = validarTexto(marca, "La marca");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = validarTexto(modelo, "El modelo");
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (!Double.isFinite(precioBase) || precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor que cero.");
        }
        this.precioBase = precioBase;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1970 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año de fabricación debe estar entre 1970 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * Calcula el costo estimado de mantenimiento anual.
     * Las subclases redefinen este método según el tipo de dispositivo.
     */
    public double calcularCostoMantenimiento() {
        int antiguedad = 2026 - anioFabricacion;
        return (precioBase * 0.04) + (antiguedad * 12000.0);
    }

    protected String descripcionComun() {
        return "Marca: " + marca
                + ", Modelo: " + modelo
                + ", Año: " + anioFabricacion
                + ", Precio base: $" + String.format("%.2f", precioBase);
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return descripcionComun();
    }
}
