package com.mycompany.main;

public class RobotEntrega extends Robot{
    
    private double pesoMaximoCarga; //Atributo propio de la clase Robot Entrega

    
    // Constructor que hereda los atributos de la Clase Padre "Robot" y agrega tambien su atributo propio-------------------------------------
    public RobotEntrega(double pesoMaximoCarga, int codigo, String nombre, int nivelBateria, boolean disponible) {
        super(codigo, nombre, nivelBateria, disponible);
        this.pesoMaximoCarga = pesoMaximoCarga;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
    
    // Getters Y Setters---------------------------------------------------------------------------------------------------------------------

    public double getPesoMaximoCarga() {
        return pesoMaximoCarga;
    }

    public void setPesoMaximoCarga(double pesoMaximoCarga) {
        this.pesoMaximoCarga = pesoMaximoCarga;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------

    
    // Codigo que hace Override al Original para mostrar la tarea que esta haciendo el Robot------------------------------------------------
    @Override
    public String ejecutarTarea() {
        return "El robot de entrega: " + nombre + " esta transportando un paquete.";
    }
    //--------------------------------------------------------------------------------------------------------------------------------------
    
    
    
}
