package RecepcionUrgencias;
import Paciente.Paciente;
import Habitacion.*;
import Consulta.*;

import java.util.NavigableMap;

//Cuando llega un paciente, para determinar su gravedad, se le revisa en urgencias
public class RecepcionUrgencias {

    //Se revisa al paciente, y en base de su gravedad, se el asigna a una consulta, o ingresado a una habitación
    public String asignacion(Paciente pacienteAsignado){
        String respuesta = "El paciente "+pacienteAsignado.getNombre()+" aún no ha sido revisado.";

        if (pacienteAsignado.getGravedad() == 2 )
        {
            Habitacion habitacion = primeraHabLibre(pacienteAsignado);
            if(habitacion!=null){
                pacienteAsignado.setHabitacion(habitacion);
                pacienteAsignado.setIngresado(true);
                habitacion.setOcupacion(true);
                habitacion.setLimpieza(false);
                respuesta = "El paciente "+pacienteAsignado.getNombre()+" ha sido ingresado en la habitación "+habitacion.getNumero();}
        }
        else if(pacienteAsignado.getGravedad()==1){
            Consulta consulta = primeraConLibre(pacienteAsignado);
            if(consulta!=null){
                pacienteAsignado.setConsulta(consulta);
                respuesta = "El paciente "+pacienteAsignado.getNombre()+" ha sido asignado a la consulta "+consulta.getNumero();}
        }
        return respuesta;
    }

    //Función que busca la primera habitación que se encuentre libre
    public Habitacion primeraHabLibre(Paciente paciente){

        for (int i = 0; i < ListaDeHabitaciones.habitaciones.size(); i++ ){

            Habitacion habitacion = ListaDeHabitaciones.habitaciones.get(i);

            if (habitacion.getOcupacion() == false) {
                habitacion.setPacienteAsignado(paciente);
                return habitacion;
            }
        }

        return null;
    }

    //Función que busca la primera consulta que se encuentre libre
    public Consulta primeraConLibre(Paciente paciente){

        for (int i = 0; i < ListaDeConsultas.consultas.size(); i++ ){

            Consulta consulta = ListaDeConsultas.consultas.get(i);

            if (consulta.getPacienteAsignado() == null) {
                consulta.setPacienteAsignado(paciente);
                return consulta;
            }
        }
        return null;

    }

}
