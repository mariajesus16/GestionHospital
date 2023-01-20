package Consulta;

import Habitacion.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsultas {

    static Consulta con1 = new Consulta("Por iniciativa del paciente, preferentemente organizada a través de cita previa.","Consulta a demanda");
    static Consulta con2 = new Consulta("Realizada por iniciativa de un profesional sanitario.","Consulta programada");
    static Consulta con3 = new Consulta("Por motivos no demorables.","Consulta urgente");

    // Utilizar al iniciar el programa para que vuelque las tres consultas en la lista
    public static void rellenarListaConsultas(){
        consultas.add(con1);
        consultas.add(con2);
        consultas.add(con3);
    }

    public static List<Consulta> consultas = new ArrayList<Consulta>();


}
