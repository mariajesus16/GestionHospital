package Empleados;

import Habitacion.Habitacion;

public class Limpiador extends Empleado {
    private Habitacion hab = null;

    public Limpiador(String dni, String nombre) {
        super(dni, nombre);
    }

    public void setHab(Habitacion hab) {
        this.hab = hab;
    }

    public Habitacion getHab() {
        return hab;
    }

    public void Limpiar(Habitacion habitacion) {
        this.hab = null;

    }

}
