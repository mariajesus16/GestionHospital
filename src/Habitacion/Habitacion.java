package Habitacion;

import Paciente.Paciente;

public class Habitacion {

    private Boolean ocupada;

    private Boolean limpia;

    private Paciente pacienteAsignado = null;

    public Habitacion(Boolean ocupada, Boolean limpia) {
        this.ocupada = ocupada;
        this.limpia = limpia;
    }

    public void setOcupacion(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Boolean getOcupacion() {
        return ocupada;
    }

    public void setLimpieza(Boolean limpia) {
        this.limpia = limpia;
    }

    public Boolean getLimpieza() {
        return limpia;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

}
