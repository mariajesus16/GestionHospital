import Consulta.Consulta;
import Consulta.ListaDeConsultas;
import Empleados.Celador;
import Empleados.Enfermero;
import Empleados.Limpiador;
import Empleados.Medico;
import Habitacion.Habitacion;
import Habitacion.ListaDeHabitaciones;
import Paciente.Paciente;
import java.util.Scanner;

public class Main {

    //Función para encontrar la primera habitación que se encuentre sucia
    public Habitacion habSucia(){
        for (int i = 0; i <= ListaDeHabitaciones.habitaciones.size(); i++ ){

            Habitacion habitacion = ListaDeHabitaciones.habitaciones.get(i);

            if (habitacion.getOcupacion() == false && habitacion.getLimpieza() == false) {
                return habitacion;
            }
        }
        return null;
    }

    //Función con las acciones del empleado médico
    public static void meds(int respuesta, Medico med){
        if(respuesta==1){
            for(Consulta consulta:ListaDeConsultas.consultas){
                if(consulta.getPacienteAsignado()!= null){
                    med.VisitaConsultas(consulta.getPacienteAsignado());
                }
                else if(respuesta==2){

                }
                else System.out.println("Comando erróneo.");
            }
        }
    }

    //Función con las acciones del empleado enfermero
    public static void enfs(int respuesta, Enfermero enf){}

    //Función con las acciones del empleado limpiador
    public static void limps(int respuesta, Limpiador limp){}

    //Función con las acciones del empleado celador
    public static void cels(int respuesta, Celador cel){}

    //Función con las acciones del paciente
    public static void pacs(){}
    public static void main() {
        //Datos de prueba
        Medico[] medicos = new Medico[]{new Medico("6438999I","Antonio","Otorrino"),
                new Medico("348583792Y","Manuela","Familia")};
        Enfermero[] enfermeros = new Enfermero[]{new Enfermero("6464222U","Manolo","Urgencias"),
                new Enfermero("353453633O","Samantha","Extracciones")};
        Limpiador[] limpiadores = new Limpiador[]{new Limpiador("24354667J","Menganito"),
                new Limpiador("354311116U","Menganita")};
        Celador[] celadores = new Celador[]{new Celador("3243423G","Pancracio"),
                new Celador("353453666T","Julia")};
        Paciente paciente = new Paciente("4453633U","Loquesea","Martínez","00000002","Dolor de muela");
        paciente.setConsulta(ListaDeConsultas.consultas.get(1));
        ListaDeConsultas.consultas.get(1).setPacienteAsignado(paciente);
        Paciente paciente2 = new Paciente("53453663O","Pepito","Martínez","56423423","No puede respirar");
        paciente2.setHabitacion(ListaDeHabitaciones.habitaciones.get(7));
        ListaDeHabitaciones.habitaciones.get(7).setPacienteAsignado(paciente2);
        paciente2.setIngresado(true);
        paciente2.setVisitas(true);
        Scanner sc = new Scanner(System.in);
        Scanner scS = new Scanner(System.in);
        Boolean salir = false;

        //Menú de interacción con el usuario
        while(!salir){
            System.out.println("¿Qué desea hacer? \n-1 Seleccionar acción  \n-2 Salir");
            int respuesta = sc.nextInt();
            if(respuesta==1){
                System.out.println("Soy...\n-1 Médic@\n-2 Enfermer@\n -3 Limpiador@\n -4 Celador@\n -5 Paciente");
                int soy = sc.nextInt();
                System.out.println("Introduce tu dni: ");
                String dni = scS.nextLine();
                switch(soy){
                    case 1:
                        Medico med = null;
                        for(Medico medico:medicos){
                            if(medico.getDni().contains(dni)){
                                med = medico;
                            }
                        }
                        if(med != null){
                            System.out.println("Bienvenid@ "+med.getNombre()+", ¿qué deseas hacer?\n-1 Atender consulta\n-2 Paciente ingresado");
                            meds(sc.nextInt(),med);
                        }
                        else{
                        System.out.println("Médic@ no encontrad@");}
                        break;
                    case 2:
                        Enfermero enf = null;
                        for(Enfermero enfermero:enfermeros){
                            if(enfermero.getDni().contains(dni)){
                                enf = enfermero;
                            }
                        }
                        if(enf != null){
                            System.out.println("Bienvenid@ "+enf.getNombre()+", ¿qué deseas hacer?\n-1 Atender consulta\n-2 Paciente ingresado");
                            enfs(sc.nextInt(),enf);
                        }
                        else{
                            System.out.println("Enfermer@ no encontrad@");}
                        break;
                    case 3:
                        Limpiador limp = null;
                        for(Limpiador limpiador:limpiadores){
                            if(limpiador.getDni().contains(dni)){
                                limp = limpiador;
                            }
                        }
                        if(limp != null){
                            System.out.println("Bienvenid@ "+limp.getNombre()+", ¿qué deseas hacer?\n-1 Encontrar habitación sucia\n-2 Limpiar habitación asignada");
                            limps(sc.nextInt(),limp);
                        }
                        else{
                            System.out.println("Limpiador@ no encontrad@");}
                        break;
                    case 4:
                        Celador cel = null;
                        for(Celador celador:celadores){
                            if(celador.getDni().contains(dni)){
                                cel = celador;
                            }
                        }
                        if(cel != null){
                            System.out.println("Bienvenid@ "+cel.getNombre()+", ¿qué deseas hacer?\n-1 Transportar paciente\n-2 LLevar comida\n-3 Realizar curas");
                            cels(sc.nextInt(),cel);
                        }
                        else{
                            System.out.println("Celador@ no encontrad@");}
                        break;
                    case 5:
                        pacs();
                        break;
                    default:
                        System.out.println("Número erróneo.");
                }
            }
            else if(respuesta==2){
                System.out.println("Adiós!");
                salir = true;
            }
            else System.out.println("Comando incorrecto.");
        }
    }
}