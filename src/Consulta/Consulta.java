package Consulta;

import Paciente.Paciente;

public class Consulta {

    // descripcion de la consulta
    private String descripcion;

    // tipo de consulta respecto a su urgencia
    private String tipo;

    // paciente que pasa la consulta, una vez ha sido revisado este campo pasará a ser Null
    private Paciente pacienteAsignado = null;

    // Constructor
    public Consulta(String material, String tipo) {
        this.descripcion = material;
        this.tipo = tipo;
    }

    // setters y getters

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


    // manda un mensaje de que el paciente ya ha sido revisado y cambia este a Null
    public String revisarPaciente(){

        this.pacienteAsignado = null;

        return "el paciente ha sido revisado";

    }



}
