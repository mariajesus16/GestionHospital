package Empleados;

import Consulta.Consulta;
import Paciente.Paciente;

//Clase Medico que hereda de la clase abstracta Empleado
public class Medico extends Empleado {
    //Atributo de la clase medico
    private Consulta consulta = null;
    private String espacialidad;

    private String anioGraduacion;

    public Medico(String dni, String nombre, String espacialidad) {
        super(dni, nombre);
        this.espacialidad = espacialidad;
    }

    public Medico(String dni, String nombre, String especialidad, String anioGraduacion){
        super(dni,nombre);
        this.espacialidad = especialidad;
        this.anioGraduacion = anioGraduacion;
    }

    //Si la consulta no es null, el paciente pasa a una consulta.
    public String VisitaConsultas(Paciente paciente) {
        String respuesta = "";
        if(consulta!=null){
            respuesta = "El Paciente " + paciente.getNombre() + " con DNI: " + paciente.getDni() + " ha pasado a consulta.";
            paciente.setConsulta(null);
            consulta.setPacienteAsignado(null);
            consulta = null;
            }
        else {
            respuesta = "El médico no tiene consulta asignada.";
        }

        return respuesta;
    }

    public static void MandarTratamientos(Paciente paciente, String tratamiento) {
        paciente.setTratamiento(tratamiento);
    }

    //getters y setters
    public void setAnioGraduacion(String anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public String getAnioGraduacion() {
        return anioGraduacion;
    }

    public String getEspacialidad() {
        return espacialidad;
    }

    public void setEspacialidad(String espacialidad) {
        this.espacialidad = espacialidad;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }
}
