package Empleados;

import Habitacion.Habitacion;
import Paciente.Paciente;

public class Celador extends Empleado {

    private String anioIncorporacion;
    private String especializacion;
    public Celador(String dni, String nombre) {
        super(dni, nombre);
    }

    public Celador(String dni, String nombre, String anioIncorporacion){
        super(dni,nombre);
        this.anioIncorporacion = anioIncorporacion;
    }
    public Celador(String dni, String nombre, String anioIncorporacion, String especializacion){
        super(dni, nombre);
        this.anioIncorporacion = anioIncorporacion;
        this.especializacion = especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setAnioIncorporacion(String anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public static void LLevarComida(Paciente paciente, String comida) {
        paciente.setComida(comida);
    }

    //Transporta a un paciente a la habitación.
    public static void TransportarPacientes(Paciente paciente, Habitacion habitacion) {
        paciente.setHabitacion(habitacion);
    }

    public String HacerCuras(Paciente paciente) {
        return "El celador le ha realizado las curas al paciente " + paciente.getNombre();
    }
}
