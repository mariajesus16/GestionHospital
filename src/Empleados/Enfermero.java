package Empleados;

import Paciente.Paciente;

public class Enfermero extends Empleado {
    private Paciente paciente = null;
    private String especialidad;

    public Enfermero(String dni, String nombre, String especialidad) {
        super(dni, nombre);
        this.especialidad = especialidad;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
