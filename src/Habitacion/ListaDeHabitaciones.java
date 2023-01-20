package Habitacion;

import Consulta.Consulta;
import Habitacion.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ListaDeHabitaciones {

    static Habitacion hab1 = new Habitacion(true,false);
    static Habitacion hab2 = new Habitacion(true,false);
    static Habitacion hab3 = new Habitacion(true,false);
    static Habitacion hab4 = new Habitacion(true,false);
    static Habitacion hab5 = new Habitacion(true,false);
    static Habitacion hab6 = new Habitacion(true,false);
    static Habitacion hab7 = new Habitacion(true,false);
    static Habitacion hab8 = new Habitacion(true,false);
    static Habitacion hab9 = new Habitacion(true,false);
    static Habitacion hab10 = new Habitacion(true,false);

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
