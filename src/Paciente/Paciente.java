package Paciente;


import Habitacion.Habitacion;
import Consulta.Consulta;

//Clase paciente, posee atributos de paciente, y atributos de asignación en función de sus necesidades
public class Paciente {
    private Habitacion hab = null;
    private Consulta con = null;
    private String dni;
    private String nombre;
    private String apellidos;
    private String numeroDeRegistro;
    private int gravedad = 0;
    private String dolencia = "";
    private String tratamiento = null;
    private String comida = null;
    private Boolean ingresado = false;
    private Boolean visitas = false;

    public Paciente(String dni, String nombre, String apellidos, String numeroDeRegistro, String dolencia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDeRegistro = numeroDeRegistro;
        this.dolencia = dolencia;
    }

    //getters y setters
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroDeRegistro(String numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setDolencia(String dolencia) {
        this.dolencia = dolencia;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public int getGravedad() {
        return gravedad;
    }

    public String getDolencia() {
        return dolencia;
    }

    public String getComida() {
        return comida;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setHabitacion(Habitacion hab) {
        this.hab = hab;
    }


    public void setConsulta(Consulta con){
        this.con = con;}

    public Habitacion getHabitacion(){
        return hab;}
    public Consulta getConsulta(){
        return con;}

    public void setIngresado(Boolean ingresado){
        this.ingresado = ingresado;}

    public void setVisitas(Boolean ingresado){
        this.ingresado = ingresado;}
    public Boolean getIngresado(){
        return ingresado;}
    public Boolean getVisitas(){
        return visitas;}
}
