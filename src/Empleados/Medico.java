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
        if(consulta!=null){
            consulta = null;
            paciente.setConsulta(null);
            consulta.setPacienteAsignado(null);
            return "El Paciente " + paciente.getNombre() + " con DNI: " + paciente.getDni() + " ha pasado a consulta.";}
        else {
            return "El médico no tiene consulta asignada.";
        }
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
