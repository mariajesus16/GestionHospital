package Consulta;

import Paciente.Paciente;

public class Consulta {

    private String descripcion;

    private String tipo;

    private Paciente pacienteAsignado = null;

    public Consulta(String material, String tipo) {
        this.descripcion = material;
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }


    public String revisarPaciente(){

        this.pacienteAsignado = null;

        return "el paciente ha sido revisado";

    }



}
