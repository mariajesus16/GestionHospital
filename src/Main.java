import Consulta.Consulta;
import Consulta.ListaDeConsultas;
import Empleados.Celador;
import Empleados.Enfermero;
import Empleados.Limpiador;
import Empleados.Medico;
import Habitacion.Habitacion;
import Habitacion.ListaDeHabitaciones;
import Paciente.Paciente;
import RecepcionUrgencias.RecepcionUrgencias;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String commandNotFound = "Comando erróneo";

    //Función para encontrar la primera habitación que se encuentre sucia
    public static Habitacion habSucia(){
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
        //Si elige pasar consulta, busca la primera consulta que necesite un médico, y pasa consulta
        if(respuesta==1){
            for(Consulta consulta:ListaDeConsultas.consultas){
                if(consulta.getPacienteAsignado()!= null){
                    med.VisitaConsultas(consulta.getPacienteAsignado());
                }}}
        //Si elige visitar habitación, busca la primera habitación que necesite un médico
        else if(respuesta==2){
            for(Habitacion habitacion:ListaDeHabitaciones.habitaciones){
                if(habitacion.getPacienteAsignado()!= null){
                    med.MandarTratamientos(habitacion.getPacienteAsignado(),"tratamiento");
                    habitacion.getPacienteAsignado().setHabitacion(null);
                    habitacion.setPacienteAsignado(null);
                    habitacion.setOcupacion(false);
                }}
                }
        else System.out.println(commandNotFound);
            }


    //Función con las acciones del empleado enfermero
    public static void enfs(int respuesta, Enfermero enf){
        if(respuesta==1){
            for(Consulta consulta:ListaDeConsultas.consultas){
                if(consulta.getPacienteAsignado()!= null){
                    System.out.println(enf.getNombre()+"atiende a "+consulta.getPacienteAsignado().getNombre()+" en la consulta "+
                            consulta.getNumero());
                }}}
        else if(respuesta==2){
            for(Habitacion habitacion:ListaDeHabitaciones.habitaciones){
                if(habitacion.getPacienteAsignado()!= null){
                    System.out.println(enf.getNombre()+"atiende a "+habitacion.getPacienteAsignado().getNombre()+" en la habitación "+
                            habitacion.getNumero());
                }}
        }
        else System.out.println(commandNotFound);
    }

    //Función con las acciones del empleado limpiador
    public static void limps(int respuesta, Limpiador limp){
        if(respuesta==1){
            Habitacion hab = habSucia();
            limp.setHab(hab);
            System.out.println("Se te asigna la habitación "+hab.getNumero());
        }
        //Si elige limpiar una habitación, en caso de que ya tuviera una asignada limpia esa, pero sino tenía ninguna
        //busca la primera habitación que necesite ser limpiada
        else if(respuesta==2){
            if(limp.getHab()!=null){
            limp.Limpiar(limp.getHab());}
            else{
                limp.Limpiar(habSucia());
            }
        }
        else System.out.println(commandNotFound);
    }

    //Función con las acciones del empleado celador
    public static void cels(int respuesta, Celador cel){
        Paciente paciente = null;
        for(Habitacion habitacion:ListaDeHabitaciones.habitaciones){
            if(habitacion.getOcupacion()==true){
                paciente = habitacion.getPacienteAsignado();
            }
        }
        switch(respuesta){
            case 1:
                cel.TransportarPacientes(paciente,paciente.getHabitacion());
                System.out.println("Transporta al paciente "+paciente.getNombre()+" a la habitación "+paciente.getHabitacion());
                break;
            case 2:
                cel.LLevarComida(paciente,"comida");
                System.out.println("Lleva comida a la habitación "+paciente.getHabitacion());
                break;
            case 3:
                cel.HacerCuras(paciente);
                System.out.println("Realiza curas al paciente "+paciente.getNombre()+" de la habitación "+paciente.getHabitacion());
                break;
            default:
                System.out.println(commandNotFound);
                break;}
    }

    //Función con las acciones del paciente
    public static void pacs(){
        //Pide los datos al paciente
        Scanner dLines = new Scanner(System.in);
        System.out.println("Introduce tu dni: ");
        String dni = dLines.nextLine();
        System.out.println("Introduce tu nombre: ");
        String nombre = dLines.nextLine();
        System.out.println("Introduce tus apellidos: ");
        String apellidos = dLines.nextLine();
        System.out.println("Introduce tu número de registro: ");
        String num = dLines.nextLine();
        System.out.println("¿Qué te ocurre?");
        String dolencia = dLines.nextLine();
        Paciente pac = new Paciente(dni,nombre,apellidos,num,dolencia);
        //Se le da un número random para la gravedad para simular el paso por la revisión en urgencias
        Random rand = new Random();
        int x = rand.nextInt(1)+1;
        pac.setGravedad(x);
        //En base a su gravedad se decide qué hacer con el paciente
        RecepcionUrgencias urg = new RecepcionUrgencias();
        urg.asignacion(pac);
    }
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
                        break;
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