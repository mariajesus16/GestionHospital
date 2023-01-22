package Empleados;

import Paciente.Paciente;

public class Enfermero extends Empleado {
    private Paciente paciente = null;
    private String especialidad;

    private String anioGraduacion;

    public Enfermero(String dni, String nombre, String especialidad) {
        super(dni, nombre);
        this.especialidad = especialidad;
    }

    public Enfermero(String dni,String anioGraduacion){
        super(dni);
        this.anioGraduacion = anioGraduacion;
    }

    public Enfermero(String dni, String nombre, String especialidad, String anioGraduacion) {
        super(dni, nombre);
        this.especialidad = especialidad;
        this.anioGraduacion = anioGraduacion;
    }

    public void setAnioGraduacion(String anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public String getAnioGraduacion() {
        return anioGraduacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
