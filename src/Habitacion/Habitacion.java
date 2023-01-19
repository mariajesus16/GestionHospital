package Habitacion;

import Paciente.Paciente;

public class Habitacion {

    private Boolean ocupada;

    private Boolean limpia;

    private Paciente pacienteAsignado = null;

    public Habitacion(Boolean ocupada, Boolean limpia, Paciente pacienteAsignado) {
        this.ocupada = ocupada;
        this.limpia = limpia;
    }

}
