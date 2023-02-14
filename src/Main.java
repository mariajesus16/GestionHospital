import Consulta.Consulta;
import Consulta.ListaDeConsultas;
import DB.Conexion;
import Empleados.*;
import Habitacion.Habitacion;
import Habitacion.ListaDeHabitaciones;
import Paciente.Paciente;
import RecepcionUrgencias.RecepcionUrgencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {


    static String commandNotFound = "Comando erróneo";

    //Función para encontrar la primera habitación que se encuentre sucia
    private static Habitacion habSucia() {
        for (int i = 0; i < ListaDeHabitaciones.habitaciones.size(); i++) {

            Habitacion habitacion = ListaDeHabitaciones.habitaciones.get(i);

            if ( habitacion.getLimpieza() == false) {
                return habitacion;
            }
        }

        return null;
    }

    //Función con las acciones del empleado médico
    public static Boolean meds(int respuesta, Medico med) throws SQLException, ClassNotFoundException {
        Boolean seguir = true;
        //Si elige pasar consulta, busca la primera consulta que necesite un médico, y pasa consulta
        if (respuesta == 1) {
            Consulta con = null;
            for (Consulta consulta : ListaDeConsultas.consultas) {
                if (consulta.getPacienteAsignado() != null) {
                    con = consulta;
                    med.setConsulta(consulta);
                    System.out.println(med.VisitaConsultas(med.getConsulta().getPacienteAsignado()));
                }
            }
            if (con == null) {
                System.out.println("No hay pacientes que atender actualmente.");
            }
        }
        //Si elige visitar habitación, busca la primera habitación que necesite un médico
        else if (respuesta == 2) {
            Habitacion hab = null;
            for (Habitacion habitacion : ListaDeHabitaciones.habitaciones) {
                if (habitacion.getPacienteAsignado() != null) {
                    hab = habitacion;
                    med.MandarTratamientos(habitacion.getPacienteAsignado(), "tratamiento");
                    System.out.println("El médico ha atendido al paciente " + habitacion.getPacienteAsignado().getNombre() + " en la habitación " +
                            habitacion.getNumero());
                    habitacion.getPacienteAsignado().setHabitacion(null);
                    habitacion.setPacienteAsignado(null);
                    habitacion.setOcupacion(false);
                }
            }
            if (hab == null) {
                System.out.println("No hay pacientes ingresados.");
            }
            // Si elige listar consultas
        } else if (respuesta == 3) {

            Conexion micone = new Conexion();

            micone.selectAllConsultas();

        } else if (respuesta == 4) {
            Conexion micone = new Conexion();

            micone.borrarConsulta();

        } else if (respuesta == 5) {
            Conexion micone = new Conexion();
            micone.insertarConsulta();

        } else if (respuesta == 6) {
            Conexion micone = new Conexion();
            micone.insertarHabitacion();

        } else if (respuesta == 7) {
            Conexion micone = new Conexion();
            micone.selectAllHabitaciones();

        }else if (respuesta == 8){
            Conexion micone = new Conexion();
            micone.insertPaciente();

        } else if(respuesta == 9){
            Conexion micone = new Conexion();
            micone.mandarTratamiento();

        } else if (respuesta == 10){
            Conexion micone = new Conexion();
            micone.darAltaPaciente();

        }else if(respuesta == 11){
            Conexion micone = new Conexion();
            micone.selectAllPacientes();

        }else if (respuesta == 0) {
            seguir = false;
        } else System.out.println(commandNotFound);

        return seguir;
    }


    //Función con las acciones del empleado enfermero
    public static Boolean enfs(int respuesta, Enfermero enf) {
        Boolean seguir = true;
        if (respuesta == 1) {
            Consulta con = null;
            for (Consulta consulta : ListaDeConsultas.consultas) {
                if (consulta.getPacienteAsignado() != null) {
                    con = consulta;
                    System.out.println(enf.getNombre() + "atiende a " + consulta.getPacienteAsignado().getNombre() + " en la consulta " +
                            consulta.getNumero());
                }
            }
            if (con == null) {
                System.out.println("No hay pacientes que atender actualmente.");
            }
        } else if (respuesta == 2) {
            Habitacion hab = null;
            for (Habitacion habitacion : ListaDeHabitaciones.habitaciones) {
                if (habitacion.getPacienteAsignado() != null) {
                    hab = habitacion;
                    System.out.println(enf.getNombre() + "atiende a " + habitacion.getPacienteAsignado().getNombre() + " en la habitación " +
                            habitacion.getNumero());
                }
            }
            if (hab == null) {
                System.out.println("No hay pacientes ingresados.");
            }
        }else if(respuesta == 3){
            Conexion micone = new Conexion();

            micone.selectAllConsultas();
        }else if (respuesta == 4){
            Conexion micone = new Conexion();

            micone.selectAllHabitaciones();
        } else if (respuesta == 5) {
            Conexion micone = new Conexion();
            micone.insertPaciente();

        } else if (respuesta == 6){
            Conexion micone = new Conexion();
            micone.darComida();

        }else if(respuesta == 7){
            Conexion micone = new Conexion();
            micone.selectAllPacientes();

        }else if (respuesta == 0) {
            seguir = false;
        } else System.out.println(commandNotFound);

        return seguir;
    }

    //Función con las acciones del empleado limpiador
    public static Boolean limps(int respuesta, Limpiador limp) {
        Boolean seguir = true;
        Habitacion hab = habSucia();
        if (hab == null) {
            System.out.println("No hay habitaciones sucias.");
            seguir = false;
        } else {
            if (respuesta == 1) {
                limp.setHab(hab);
                System.out.println("Se te asigna la habitación " + hab.getNumero());
            }
            //Si elige limpiar una habitación, en caso de que ya tuviera una asignada limpia esa, pero sino tenía ninguna
            //busca la primera habitación que necesite ser limpiada
            else if (respuesta == 2) {
                if (limp.getHab() != null) {
                    System.out.println("La habitación " + limp.getHab().getNumero() + " ha sido limpiada.");
                    limp.Limpiar(limp.getHab());

                } else {
                    limp.Limpiar(hab);
                    System.out.println("La habitación " + hab.getNumero() + " ha sido limpiada");
                }
            }else if (respuesta == 3) {
                Conexion micone = new Conexion();
                micone.limpiarHabitacion();
            }else if (respuesta == 0) {
                seguir = false;
            } else System.out.println(commandNotFound);
        }

        return seguir;
    }

    //Función con las acciones del empleado celador
    public static Boolean cels(int respuesta, Celador cel) {
        Boolean seguir = true;
        Paciente paciente = null;
        for (Habitacion habitacion : ListaDeHabitaciones.habitaciones) {
            if (habitacion.getOcupacion() == true) {
                paciente = habitacion.getPacienteAsignado();
            }
        }
        if (paciente == null) {
            System.out.println("No hay pacientes ingresados.");
            seguir = false;
        } else {
            switch (respuesta) {
                case 1:
                  /*
                    cel.TransportarPacientes(paciente, paciente.getHabitacion());
                    System.out.println("Transporta al paciente " + paciente.getNombre() + " a la habitación " + paciente.getHabitacion());
                    break; */

                    Conexion lacone = new Conexion();
                    lacone.transportarPaciente();
                case 2:
                    Conexion micone = new Conexion();
                    micone.darComida();
                    /*
                    cel.LLevarComida(paciente, "comida");
                    System.out.println("Lleva comida a la habitación " + paciente.getHabitacion());
                    break;*/
                case 3:
                    System.out.println(cel.HacerCuras(paciente));
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println(commandNotFound);
                    break;
            }
        }

        return seguir;
    }

    //Función con las acciones del paciente
    public static void pacs(String dni) {
        //Pide los datos al paciente
        Scanner dLines = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = dLines.nextLine();
        System.out.println("Introduce tus apellidos: ");
        String apellidos = dLines.nextLine();
        System.out.println("Introduce tu número de registro: ");
        String num = dLines.nextLine();
        System.out.println("¿Qué te ocurre?");
        String dolencia = dLines.nextLine();
        Paciente pac = new Paciente(dni, nombre, apellidos, num, dolencia);
        //Se le da un número random para la gravedad para simular el paso por la revisión en urgencias
        Random rand = new Random();
        int x = rand.nextInt(1) + 1;
        pac.setGravedad(x);
        //En base a su gravedad se decide qué hacer con el paciente
        RecepcionUrgencias urg = new RecepcionUrgencias();
        System.out.println(urg.asignacion(pac));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
     //   Conexion conexion = new Conexion();

      //  var listaEmpleados = conexion.selectAllEmpleadosIntroducirEnLista();
        

        ListaDeHabitaciones.rellenarListaHabitaciones();
        ListaDeConsultas.rellenarListaConsultas();
/*
        Conexion conexion = new Conexion();

//        conexion.createTableConsulta();
//      conexion.createTableEmpleado();
//        conexion.createTableHabitacion();
 //       conexion.createTablePaciente();



        // AL INICIAR EL PROGRAMA VOLCAMOS TODAS LAS CONSULTAS Y HABITACIONES DE LAS LISTAS QUE TENIAMOS ANTES
        // HACIA SUS RESPECTIVAS TABLAS DE LA BASE DE DATOS, UNA VEZ HECHO ESTO PODEMOS COMENTAR ESTA PARTE

 /*       for (int i = 0; i < ListaDeConsultas.consultas.size(); i++) {
            Consulta element = ListaDeConsultas.consultas.get(i);

          //  Conexion conexion1 = new Conexion();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/hospital_bd", "hospital", "123456789");
                if (!conn.isClosed()) System.out.println("Conexion realizada...");

                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate("INSERT INTO consulta VALUES (" + element.getNumero() + " ,'" + element.getDescripcion() + "', '" + element.getTipo() + "' )");
                    //  conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception");
                    System.err.println(e.getMessage());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }


        for (int i = 0; i < ListaDeHabitaciones.habitaciones.size(); i++) {
            Habitacion element = ListaDeHabitaciones.habitaciones.get(i);

        //    Conexion conexion = new Conexion();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/hospital_bd", "hospital", "123456789");
                if (!conn.isClosed()) System.out.println("Conexion realizada...");

                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate("INSERT INTO habitacion VALUES (" + element.getNumero() + " ,'" + element.getOcupacion().toString() + "', '" + element.getLimpieza().toString() + "','" + element.getPacienteAsignado().getDni() + "' );");
                    //  conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception");
                    System.err.println(e.getMessage());
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
*/

        //Datos de prueba
        Medico[] medicos = new Medico[]{new Medico("6438999I", "Antonio", "Otorrino"),
                new Medico("348583792Y", "Manuela", "Familia")};
        Enfermero[] enfermeros = new Enfermero[]{new Enfermero("6464222U", "Manolo", "Urgencias"),
                new Enfermero("353453633O", "Samantha", "Extracciones")};
        Limpiador[] limpiadores = new Limpiador[]{new Limpiador("24354667J", "Menganito"),
                new Limpiador("354311116U", "Menganita")};
        Celador[] celadores = new Celador[]{new Celador("3243423G", "Pancracio"),
                new Celador("353453666T", "Julia")};
        ListaDeHabitaciones.habitaciones.get(3).setLimpieza(false);
        Paciente paciente = new Paciente("4453633U", "Loquesea", "Martínez", "00000002", "Dolor de muela");
        paciente.setConsulta(ListaDeConsultas.consultas.get(1));
        ListaDeConsultas.consultas.get(1).setPacienteAsignado(paciente);
        Paciente paciente2 = new Paciente("53453663O", "Pepito", "Martínez", "56423423", "No puede respirar");
        paciente2.setHabitacion(ListaDeHabitaciones.habitaciones.get(7));
        ListaDeHabitaciones.habitaciones.get(7).setPacienteAsignado(paciente2);
        paciente2.setIngresado(true);
        paciente2.setVisitas(true);
        Scanner sc = new Scanner(System.in);
        Scanner scS = new Scanner(System.in);
        Boolean salir = false;






        //Menú de interacción con el usuario
        while (!salir) {
            System.out.println("¿Qué desea hacer? \n-1 Seleccionar acción  \n-2 Salir");
            int respuesta = sc.nextInt();
            if (respuesta == 1) {
                System.out.println("Soy...\n-1 Médic@\n-2 Enfermer@\n -3 Limpiador@\n -4 Celador@\n -5 Paciente");
                int soy = sc.nextInt();
                System.out.println("Introduce tu dni: ");
                String dni = scS.nextLine();
                Boolean seguir = true;
                switch (soy) {
                    case 1:
                        Medico med = null;
                        for (Medico medico : medicos) {
                            if (medico.getDni().contains(dni)) {
                                med = medico;
                            }
                        }
                        if (med != null) {
                            System.out.println("Bienvenid@ " + med.getNombre());
                            while (seguir) {
                                System.out.println("¿Qué deseas hacer?\n-1 Atender consulta\n-2 Paciente ingresado\n-3 Listar Consultas (BBDD)" +
                                        "\n-4 Eliminar consulta de la BD (BBDD)\n-5 Insertar nueva consulta (BBDD)\n-6 Insertar habitacion nueva (BBDD)" +
                                        "\n-7 Listar habitaciones (BBDD)\n-8 Insertar Paciente Nuevo (BBDD)\n-9 Mandar Tratamiento (BBDD)\n-10 Dar de alta a un paciente (BBDD)\n-11 Listar pacientes (BBDD)  \n-0 Salir");
                                seguir = meds(sc.nextInt(), med);
                            }
                        } else {
                            System.out.println("Médic@ no encontrad@");
                        }
                        break;
                    case 2:
                        Enfermero enf = null;
                        for (Enfermero enfermero : enfermeros) {
                            if (enfermero.getDni().contains(dni)) {
                                enf = enfermero;
                            }
                        }
                        if (enf != null) {
                            System.out.println("Bienvenid@ " + enf.getNombre());
                            while (seguir) {
                                System.out.println("¿Qué deseas hacer?\n-1 Atender consulta\n-2 Paciente ingresado\n-3 Ver Consultas (BBDD)\n-4 Ver Habitaciones (BBDD)\n-5 Registrar Paciente (BBDD)\n-6 Dar Comida (BBDD)\n-7 Listar Pacientes (BBDD) \n-0 Salir");
                                seguir = enfs(sc.nextInt(), enf);
                            }
                        } else {
                            System.out.println("Enfermer@ no encontrad@");
                        }
                        break;
                    case 3:
                        Limpiador limp = null;
                        for (Limpiador limpiador : limpiadores) {
                            if (limpiador.getDni().contains(dni)) {
                                limp = limpiador;
                            }
                        }
                        if (limp != null) {
                            System.out.println("Bienvenid@ " + limp.getNombre());
                            while (seguir) {
                                System.out.println("¿Qué deseas hacer?\n-1 Encontrar habitación sucia\n-2 Limpiar habitación asignada\n-3 Limpiar habitacion por numero (BBDD)\n-0 Salir");
                                seguir = limps(sc.nextInt(), limp);
                            }
                        } else {
                            System.out.println("Limpiador@ no encontrad@");
                        }
                        break;
                    case 4:
                        Celador cel = null;
                        for (Celador celador : celadores) {
                            if (celador.getDni().contains(dni)) {
                                cel = celador;
                            }
                        }
                        if (cel != null) {
                            System.out.println("Bienvenid@ " + cel.getNombre());
                            while (seguir) {
                                System.out.println("¿Qué deseas hacer?\n-1 Transportar paciente (BBDD)\n-2 LLevar comida (BBDD)\n-3 Realizar curas\n-0 Salir");
                                seguir = cels(sc.nextInt(), cel);
                            }
                        } else {
                            System.out.println("Celador@ no encontrad@");
                        }
                        break;
                    case 5:
                        pacs(dni);
                        break;
                    default:
                        System.out.println("Número erróneo.");
                        break;
                }
            } else if (respuesta == 2) {
                System.out.println("Adiós!");
                salir = true;
            } else System.out.println("Comando incorrecto.");
            
            
        }
        

        
    }
}