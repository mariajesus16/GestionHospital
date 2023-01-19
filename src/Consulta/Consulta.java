package Consulta;

import Paciente.Paciente;

public class Consulta {

    private String material;

    private String tipo;

    private Paciente pacienteAsignado = null;

    public Consulta(String material, String tipo) {
        this.material = material;
        this.tipo = tipo;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
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
