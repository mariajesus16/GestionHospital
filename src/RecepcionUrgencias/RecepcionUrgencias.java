package RecepcionUrgencias;
import Paciente.Paciente;

public class RecepcionUrgencias {

    public String asignacion(Paciente pacienteAsignado){

        if (pacienteAsignado.getGravedad() == 2 )
        { pacienteAsignado.setHabitacion(pacienteAsignado.primeraHabLibre());

        }
        return null;
    }
}
