package Empleados;

import Habitacion.Habitacion;

public class Limpiador extends Empleado {
    private Habitacion hab = null;
    private String anioIncorporacion;

    private String experiencia;

    public Limpiador(String dni, String nombre) {
        super(dni, nombre);
    }

    public Limpiador(String dni, String nombre, String anioIncorporacion){
        super(dni,nombre);
        this.anioIncorporacion = anioIncorporacion;
    }

    public Limpiador(String dni, String nombre, String anioIncorporacion, String experiencia){
        super(dni,nombre);
        this.anioIncorporacion = anioIncorporacion;
        this.experiencia = experiencia;
    }

    public void setAnioIncorporacion(String anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setHab(Habitacion hab) {
        this.hab = hab;
    }

    public Habitacion getHab() {
        return hab;
    }

    public void Limpiar(Habitacion habitacion) {
        this.hab = null;
        habitacion.setLimpieza(true);
    }

}
