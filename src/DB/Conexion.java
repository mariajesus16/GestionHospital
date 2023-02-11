package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class Conexion {

    final String usuario = "root";
    final String password = "";
    Connection dbConnection = null;
    Statement statement = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/hospital_bd";

    public void insertarHabitacion() throws ClassNotFoundException{
        System.out.println("Escribe el numero de habitacion a insertar");
        Scanner ns = new Scanner(System.in);
        int nume = ns.nextInt();

        System.out.println("Escribe true si está ocupada y false si no lo está");
        Scanner oc = new Scanner(System.in);
        String ocu = oc.nextLine();

        System.out.println("Escribe true si está limpia y false si no lo está");
        Scanner li = new Scanner(System.in);
        String lim = li.nextLine();

        System.out.println("Escribe dni del paciente , si está libre deja en blanco");
        Scanner pa = new Scanner(System.in);
        String pac = pa.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO lista_habitaciones VALUES ("+ nume +" ,'"+ ocu + "', '" + lim + "' ,'"+ pac + "'   )");
                //  conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void insertarConsulta() throws ClassNotFoundException {
        System.out.println("Escribe el numero de consulta que deseas añadir");
        Scanner ns = new Scanner(System.in);
        int nume = ns.nextInt();
        System.out.println("Define los materiales que poseerá esta consulta");
        Scanner nss = new Scanner(System.in);
        String mate = nss.nextLine() ;
        System.out.println("Define el tipo de consulta");
        Scanner nsss = new Scanner(System.in);
        String tipo = nsss.nextLine();
        //INSERT
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO lista_consultas VALUES ("+ nume +" ,'"+ mate + "', '" + tipo + "' )");
                //  conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void borrarConsulta() {
        System.out.println("Escribe el numero de consulta que deseas eliminar");
        Scanner nc = new Scanner(System.in);
        int nume = nc.nextInt();
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");
        //DELETE

        try (Statement stmt = conn.createStatement();) {
            String sql = "DELETE FROM lista_consultas WHERE numero =" + nume ;
            stmt.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void limpiarHabitacion() {
        System.out.println("Escribe el numero de habitación que deseas limpiar");
        Scanner ns = new Scanner(System.in);
        int nume = ns.nextInt();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            Statement stmt = conn.createStatement();

            String sql = "UPDATE lista_habitaciones SET limpia = 'true' WHERE numero in (" + nume + ")";

            stmt.executeUpdate(sql);

            System.out.println("La habitacion "+ nume +" será limpiada");

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

        public void selectAllHabitaciones() {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT numero,ocupada,limpia,paciente FROM lista_habitaciones ";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String num = rs.getString("numero");
                String ocu = rs.getString("ocupada");
                String lim = rs.getString("limpia");
                String pac = rs.getString("paciente");

                System.out.println("Habitación numero : " + num);
                System.out.println("Ocupada ? : " + ocu);
                System.out.println(" Limpia ? : " + lim);
                System.out.println("DNI del Paciente : " + pac);
                System.out.println("------------");

            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void selectAllConsultas() {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT numero,material,tipo FROM lista_consultas ";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String num = rs.getString("numero");
                String mat = rs.getString("material");
                String tip = rs.getString("tipo");

                System.out.println("Consulta numero : " + num);
                System.out.println("Material : " + mat);
                System.out.println("Tipo de consulta : " + tip);
                System.out.println("------------");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {


    }

}

