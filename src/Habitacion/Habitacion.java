package Habitacion;

import Paciente.Paciente;

public class Habitacion {

    //atributo que indica el número de habitación
    private int numero;

    // atributo que indica si es True la habitacion está ocupada, si es false está desocupada
    private Boolean ocupada = false;

    // atributo que nos indica que está limpia en True, si está en false no está limpia
    private Boolean limpia = true;

    // paciente que ocupa la habitación
    private Paciente pacienteAsignado = null;

    // constructor
    public Habitacion(int numero) {
        this.numero = numero;
    }

    // setters y getters

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
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
