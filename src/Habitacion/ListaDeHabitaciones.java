package Habitacion;

import Consulta.Consulta;
import Habitacion.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ListaDeHabitaciones {

    static Habitacion hab1 = new Habitacion(1);
    static Habitacion hab2 = new Habitacion(2);
    static Habitacion hab3 = new Habitacion(3);
    static Habitacion hab4 = new Habitacion(4);
    static Habitacion hab5 = new Habitacion(5);
    static Habitacion hab6 = new Habitacion(6);
    static Habitacion hab7 = new Habitacion(7);
    static Habitacion hab8 = new Habitacion(8);
    static Habitacion hab9 = new Habitacion(9);
    static Habitacion hab10 = new Habitacion(10);


    // Utilizar al iniciar el programa para que vuelque las tres consultas en la lista
    public static void rellenarListaHabitaciones(){
        habitaciones.add(hab1);
        habitaciones.add(hab2);
        habitaciones.add(hab3);
        habitaciones.add(hab4);
        habitaciones.add(hab5);
        habitaciones.add(hab6);
        habitaciones.add(hab7);
        habitaciones.add(hab8);
        habitaciones.add(hab9);
        habitaciones.add(hab10);
    }

    public static List<Habitacion> habitaciones = new ArrayList<Habitacion>();


}
