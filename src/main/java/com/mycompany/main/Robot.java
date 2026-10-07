package com.mycompany.main;

public abstract class Robot implements Recargable{
    protected int codigo;
    protected String nombre;
    protected double nivelBateria;
    protected boolean disponible; 

    public Robot(int codigo, String nombre, int nivelBateria, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelBateria = nivelBateria;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
               "\nNombre: " + nombre +
               "\nNivel de Bateria: " + nivelBateria +
               "disponible: " + (disponible ? "Si" : "No");
    }

    @Override
    public void recargar() {
        this.nivelBateria = 100.0;
        this.disponible = true;
    }
    
    
    
    public abstract String ejecutarTarea();

    public int getCodigo() {
        return codigo;
        }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(double nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
