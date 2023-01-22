package Consulta;

import Habitacion.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsultas {

    static Consulta con1 = new Consulta(1,"Paracetamol, tensiómetro, glucómetro, fonendoscopio .","Consulta a demanda");
    static Consulta con2 = new Consulta(2, "Camilla, fonendoscopio, linterna.","Consulta programada");
    static Consulta con3 = new Consulta(3,"Ecógrafo, camilla, inyecciones.","Consulta urgente");

    // Utilizar al iniciar el programa para que vuelque las tres consultas en la lista
    public static void rellenarListaConsultas(){
        consultas.add(con1);
        consultas.add(con2);
        consultas.add(con3);
    }

    public static List<Consulta> consultas = new ArrayList<Consulta>();


}
