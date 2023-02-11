package Habitacion;

import Consulta.Consulta;
import Habitacion.Habitacion;
import Paciente.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ListaDeHabitaciones {

    static Habitacion hab1 = new Habitacion(1,true,false,new Paciente("12345678o","gonzalez"));
    static Habitacion hab2 = new Habitacion(2,true,false,new Paciente("12345678j","gonzalez"));
    static Habitacion hab3 = new Habitacion(3,true,false,new Paciente("12345678p","gonzalez"));
    static Habitacion hab4 = new Habitacion(4,true,false,new Paciente("12345678i","gonzalez"));
    static Habitacion hab5 = new Habitacion(5,true,false,new Paciente("12345678y","gonzalez"));
    static Habitacion hab6 = new Habitacion(6,true,false,new Paciente("123456784","gonzalez"));
    static Habitacion hab7 = new Habitacion(7,true,false,new Paciente("12345678w","gonzalez"));
    static Habitacion hab8 = new Habitacion(8,true,false,new Paciente("12345678a","gonzalez"));
    static Habitacion hab9 = new Habitacion(9,true,false,new Paciente("12345677u","gonzalez"));
    static Habitacion hab10 = new Habitacion(10,true,false,new Paciente("12345698o","gonzalez"));


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
