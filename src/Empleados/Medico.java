package Empleados;

public class Medico extends Empleado{
    //private Consulta consulta = null;
    private String espacialidad;

    public Medico(String dni, String nombre, String espacialidad) {
        super(dni, nombre);
        this.espacialidad = espacialidad;
    }

    public static void VisitaConsultas(){

    }

    public static void MandarTratamientos(){

    }

    public String getEspacialidad() {
        return espacialidad;
    }

    public void setEspacialidad(String espacialidad) {
        this.espacialidad = espacialidad;
    }
}
