package Empleados;

//Clase abstracta Empleado
public abstract class Empleado {
    //Atributos de la clase Empleado
    private String dni;
    private String nombre;

    private String apellidos;

    private String tipo;

    public Empleado(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Empleado(String dni, String apellidos){
        this.dni = dni;
        this.apellidos = apellidos;
    }

    //getters y setters
    public Empleado(String dni){
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
