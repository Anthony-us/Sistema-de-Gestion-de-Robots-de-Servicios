package com.mycompany.main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ArrayList<Robot> listaRobots = new ArrayList<>(); //Lista donde se guardan los robots
        int opcion = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "SISTEMA DE GESTION DE ROBOTS\n\n"
                        + "1. Registrar robot\n"
                        + "2. Mostrar robots\n"
                        + "3. Ejecutar tarea\n"
                        + "4. Reporte general\n"
                        + "5. Salir\n\n"
                        + "Seleccione una opcion:"
                );
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo del Sistema...");
                    break; //Se rompe el ciclo para salir
                }
                opcion = Integer.parseInt(input); //Se convierte el texto ingresado en numero entero

                switch (opcion) {
                    case 1:
                        registrarRobot(listaRobots);
                        break;

                    case 2:
                        mostrarRobots(listaRobots);
                        break;

                    case 3:
                    //Ejecutar Tarea
                    //Aca se implementa tambien lo de la bateria (recargable)

                    case 4:
                    //Reporte GEneral

                    case 5:
                        JOptionPane.showMessageDialog(null, "¡Gracias por usar el "
                                + "sistema de gestion de robots!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida. Por favor"
                                + "seleciione un número valido del 1 al 5.");
                        break;

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un "
                        + "numero valido."); //Esto evita que el programa se 
                //caiga si el usuario ingresa letras en lugar de numeros
            }
        } while (opcion != 5); //El ciclo se repite mientras 
        //la opcion sea diferente de 5

    }

    //REGISTRAR ROBOTS
    public static void registrarRobot(ArrayList<Robot> listaRobots) {
        String tipo = JOptionPane.showInputDialog(null,
                "Seleccione el tipo de robot a registrar:\n"
                + "1. Robot de Limpieza\n"
                + "2. Robot de Entrega\n"
                + "3. Robot de Vigilancia\n"
        );

        if (tipo == null) {
            return;
        }
        int tipoRobot = Integer.parseInt(tipo); //Se convierte el texto ingresado 
        //por el usuario en entero´para evaluarlo en un switch

        if (tipoRobot < 1 || tipoRobot > 3) {
            JOptionPane.showMessageDialog(null, "Tipo de robot invalido.");
            return;
        } //Se valida que el numero sea entre 1 y 3, si no se muestra error

        //Se pide el codigo unico del robot
        String codigoRobot = JOptionPane.showInputDialog(null, "Ingrese el codigo "
                + "unico del robot (numero):");
        if (codigoRobot == null) {
            return; //si cancela, salimos
        }
        int codigo = Integer.parseInt(codigoRobot);

        //Validar que el codigo No se repita
        for (Robot r : listaRobots) {
            if (r.getCodigo() == codigo) {
                //si ya existe uno con el mismo codigo, se muestra el error 
                //y se anula su registro
                JOptionPane.showMessageDialog(null, "Error: Ya existe un robot registrado"
                        + "con el codigo" + codigo + ".");
                return;

            }
        }

        //Pedir los datos generales que comparten los robots
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del robot:");
        if (nombre == null) {
            return;
        }

        String bateriaRobot = JOptionPane.showInputDialog(null, "Ingrese el nivel de bateria (o a 100:");
        if (bateriaRobot == null) {
            return;
        }
        double nivelBateria = Double.parseDouble(bateriaRobot); //Convertimos el texto a double

        //Cuando se registra un robot siempre debe de estar DISPONIBLE
        boolean disponible = true;

        //Depende de la opcion se piden los atributos y se crea el objeto
        //Si es robot de limpieza
        switch (tipoRobot) {
            case 1:
                String deposito = JOptionPane.showInputDialog(null, "Ingrese la capacidad"
                        + "del deposito (litros:");
                if (deposito == null) {
                    return;
                }
                double capacidadDeposito = Double.parseDouble(deposito);

                //Se crea el objeto hijo y se pasa a la variable limpieza
                RobotLimpieza rLimpieza = new RobotLimpieza(capacidadDeposito, codigo, nombre, (int) nivelBateria, disponible);
                listaRobots.add(rLimpieza);
                break;

            //Si es robot de Entrega
            case 2:
                String peso = JOptionPane.showInputDialog(null, "Ingrese el peso maximo"
                        + "de carga (kg):");
                if (peso == null) {
                    return;
                }
                double pesoMaximoCarga = Double.parseDouble(peso);

                RobotEntrega rEntrega = new RobotEntrega(pesoMaximoCarga, codigo, nombre, (int) nivelBateria, disponible);
                listaRobots.add(rEntrega);
                break;

            //Si el robot es de Vigilancia
            case 3:
                String distancia = JOptionPane.showInputDialog(null, "Ingrese "
                        + "la distancia máxima de vigilancia:");
                if (distancia == null) {
                    return;
                }
                double distanciaVigilada = Double.parseDouble(distancia);

                RobotVigilancia rVigilancia = new RobotVigilancia(distanciaVigilada, codigo, nombre, (int) nivelBateria, disponible);
                listaRobots.add(rVigilancia);
                break;

        }
        JOptionPane.showMessageDialog(null, "¡Robot registrado con éxito!");

    }

    //MOSTRAR ROBOTS
    public static void mostrarRobots(ArrayList<Robot> listaRobots) {

        //Verificar si la lista esta vacia antes de mostrarla
        if (listaRobots.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay robots registrados en el sistema.");
            return; //se sale si no hay nada que mostrar
        }

        //Se crea una variable que acumule para armar una ventana 
        //grande con los datos
        String mensaje = "=== LISTA DE ROBOTS REGISTRADOS ===\n\n";
        for (Robot r : listaRobots) {

            if (r instanceof RobotLimpieza) {
                //Se hace un CASTING para transformar temporalmente el 
                //objeto general a su tipo real
                RobotLimpieza rl = (RobotLimpieza) r;
                mensaje += "Tipo: Robot de Limpieza\n"
                        + "Código: " + rl.getCodigo() + "\n"
                        + "Nombre: " + rl.getNombre() + "\n"
                        + "Bateria: " + rl.getNivelBateria() + "\n"
                        + "Disponible " + (rl.isDisponible() ? "Si" : "No") + "\n"
                        + "Capacidad de Deposito: " + rl.getCapacidadDeposito() + "L\n";

            } else if (r instanceof RobotEntrega) {
                //Se realiza el CASTING pero con RobotEntrega
                RobotEntrega re = (RobotEntrega) r;

                mensaje += "Tipo: Robot de Entrega\n"
                        + "Código: " + re.getCodigo() + "\n"
                        + "Nombre: " + re.getNombre() + "\n"
                        + "Bateria: " + re.getNivelBateria() + "\n"
                        + "Disponible " + (re.isDisponible() ? "Si" : "No") + "\n"
                        + "Capacidad de Deposito: " + re.getPesoMaximoCarga() + "kg\n";
            } else if (r instanceof RobotVigilancia) {
                RobotVigilancia rv = (RobotVigilancia) r;

                mensaje += "Tipo: Robot de Vigilancia\n"
                        + "Código: " + rv.getCodigo() + "\n"
                        + "Nombre: " + rv.getNombre() + "\n"
                        + "Bateria: " + rv.getNivelBateria() + "\n"
                        + "Disponible " + (rv.isDisponible() ? "Si" : "No") + "\n"
                        + "Capacidad de Deposito: " + rv.getDistanciaVigilada() + "m\n";

            }
            //Separador visual entre robots
            mensaje += "---------------------------------------------------\n";

        }

        //Mostramos el reporte completo 
        JOptionPane.showMessageDialog(null, mensaje);

    }

}
    

