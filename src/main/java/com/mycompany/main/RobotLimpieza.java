package com.mycompany.main;

public class RobotLimpieza extends Robot{
    
    private double capacidadDeposito; //Atributo propio de la Clase Robot Limpieza

    // Constructor que hereda los atributos de la Clase Padre "Robot" y agrega tambien su atributo propio-------------------------------------
    public RobotLimpieza(double capacidadDeposito, int codigo, String nombre, int nivelBateria, boolean disponible) {
        super(codigo, nombre, nivelBateria, disponible);
        this.capacidadDeposito = capacidadDeposito;
    }
    // ---------------------------------------------------------------------------------------------------------------------------------------
    
    // Getters Y Setters----------------------------------------------------------------------------------------------------------------------

    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(double capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    
    // Codigo que hace Override al Original para mostrar la tarea que esta haciendo el Robot-------------------------------------------------
    @Override
    public String ejecutarTarea() {
        return "El robot de limpieza " + nombre + " está realizando una tarea de limpieza.";
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    
    
    
}
