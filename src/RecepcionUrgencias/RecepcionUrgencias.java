package RecepcionUrgencias;
import Paciente.Paciente;
import Habitacion.*;
import Consulta.*;

public class RecepcionUrgencias {

    public String asignacion(Paciente pacienteAsignado){

        if (pacienteAsignado.getGravedad() == 2 )
        {
            pacienteAsignado.setIngresado(true);
            pacienteAsignado.setHabitacion(primeraHabLibre(pacienteAsignado));
        }
        else if(pacienteAsignado.getGravedad()==1){
            primeraConLibre(pacienteAsignado);
        }
        return null;
    }

    public Habitacion primeraHabLibre(Paciente paciente){

        for (int i = 0; i <= ListaDeHabitaciones.habitaciones.size(); i++ ){

            Habitacion habitacion = ListaDeHabitaciones.habitaciones.get(i);

            if (habitacion.getOcupacion() == false) {
                habitacion.setPacienteAsignado(paciente);
                return habitacion;
            }
        }

        return null;
    }

    public Consulta primeraConLibre(Paciente paciente){

        for (int i = 0; i <= ListaDeConsultas.consultas.size(); i++ ){

            Consulta consulta = ListaDeConsultas.consultas.get(i);

            if (consulta.getPacienteAsignado() == null) {
                consulta.setPacienteAsignado(paciente);
                return consulta;
            }
        }
        return null;

    }

}
