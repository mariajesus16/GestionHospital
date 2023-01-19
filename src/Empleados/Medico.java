package Empleados;

import Consulta.Consulta;
import Paciente.Paciente;

public class Medico extends Empleado {
    private Consulta consulta = null;
    private String espacialidad;

    public Medico(String dni, String nombre, String espacialidad) {
        super(dni, nombre);
        this.espacialidad = espacialidad;
    }

    public String VisitaConsultas(Paciente paciente) {
        return "El Paciente " + paciente.getNombre() + " con DNI: " + paciente.getDni() + " ha pasado a consulta.";
    }

    public static void MandarTratamientos(Paciente paciente, String tratamiento) {
        paciente.setTratamiento(tratamiento);
    }

    public String getEspacialidad() {
        return espacialidad;
    }

    public void setEspacialidad(String espacialidad) {
        this.espacialidad = espacialidad;
    }
}
