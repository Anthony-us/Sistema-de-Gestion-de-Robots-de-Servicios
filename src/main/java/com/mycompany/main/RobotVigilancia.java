package com.mycompany.main;

public class RobotVigilancia extends Robot {
    
    private double distanciaVigilada; //Atributo propio de la Clase Robot Vigilancia

     // Constructor que hereda los atributos de la Clase Padre "Robot" y agrega tambien su atributo propio-------------------------------------
    public RobotVigilancia(double distanciaVigilada, int codigo, String nombre, int nivelBateria, boolean disponible) {
        super(codigo, nombre, nivelBateria, disponible);
        this.distanciaVigilada = distanciaVigilada;
    }
     // ---------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    // Getters Y Setters----------------------------------------------------------------------------------------------------------------------
    public double getDistanciaVigilada() {
        return distanciaVigilada;
    }

    public void setDistanciaVigilada(double distanciaVigilada) {
        this.distanciaVigilada = distanciaVigilada;
    }
     //---------------------------------------------------------------------------------------------------------------------------------------
    
     // Codigo que hace Override al Original para mostrar la tarea que esta haciendo el Robot-------------------------------------------------
     @Override
    public String ejecutarTarea() {
        return "El robot de vigilancia " + nombre
                + " está realizando una ronda por el perímetro.";
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    
    
    
}