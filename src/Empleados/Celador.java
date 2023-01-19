package Empleados;

import Habitacion.Habitacion;
import Paciente.Paciente;

public class Celador extends Empleado {
    public Celador(String dni, String nombre) {
        super(dni, nombre);
    }


    public static void LLevarComida(Paciente paciente, String comida) {
        paciente.setComida(comida);
    }

    //Transporta a un paciente a la habitación.
    public static void TransportarPacientes(Paciente paciente, Habitacion habitacion) {
        paciente.setHabitacion(habitacion);
    }

    public static void HacerCuras() {

    }
}
