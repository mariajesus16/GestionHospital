package Empleados;

import Habitacion.Habitacion;

//Clase Limpiador que hereda de la clase abstracta Empleado
public class Limpiador extends Empleado {
    //Atributos de la clase limpiador
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

    //getters y setters
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
