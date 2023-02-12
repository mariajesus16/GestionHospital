package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class Conexion {

    Connection dbConnection = null;
    Statement statement = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://db4free.net:3306/hospital_bd";
    private static final String USUARIO = "hospital";
    private static final String CLAVE = "123456789";

    public void insertarHabitacion() throws ClassNotFoundException {
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
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO habitacion VALUES (" + nume + " ,'" + ocu + "', '" + lim + "' ,'" + pac + "'   )");
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
        String mate = nss.nextLine();
        System.out.println("Define el tipo de consulta");
        Scanner nsss = new Scanner(System.in);
        String tipo = nsss.nextLine();
        //INSERT
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO consulta VALUES (" + nume + " ,'" + mate + "', '" + tipo + "' )");
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
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");
            //DELETE

            try (Statement stmt = conn.createStatement();) {
                String sql = "DELETE FROM consulta WHERE numero =" + nume;
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
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
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            Statement stmt = conn.createStatement();

            String sql = "UPDATE habitacion SET limpia = 'true' WHERE numero in (" + nume + ")";

            stmt.executeUpdate(sql);

            System.out.println("La habitacion " + nume + " será limpiada");

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void selectAllHabitaciones() {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT numero,ocupada,limpia,paciente FROM habitacion ";
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
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT numero,material,tipo FROM consulta ";
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

    public void createTableHabitacion() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            statement = conn.createStatement();
            String table = "CREATE TABLE habitacion " +
                    "(numero INTEGER not NULL, " +
                    " ocupada VARCHAR(5), " +
                    " limpia VARCHAR(5), " +
                    " paciente VARCHAR(9), " +
                    " PRIMARY KEY ( numero ))";
            statement.executeUpdate(table);
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createTableConsulta() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");
            statement = conn.createStatement();
            String table = "CREATE TABLE consulta " +
                    "(numero INTEGER not NULL, " +
                    " material VARCHAR(200), " +
                    " tipo VARCHAR(50), " +
                    " PRIMARY KEY ( numero ))";
            statement.executeUpdate(table);
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createTablePaciente() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");
            statement = conn.createStatement();
            String table = "CREATE TABLE paciente " +
                    "(dni VARCHAR(9) not NULL," +
                    "habitacion INTEGER," +
                    "consulta INTEGER, " +
                    "nombre VARCHAR(50), " +
                    "apellidos VARCHAR(200)," +
                    "numeroRegistro VARCHAR(10)," +
                    "gravedad INTEGER," +
                    "dolencia VARCHAR(200)," +
                    "tratamiento VARCHAR(200)," +
                    "comida VARCHAR(200)," +
                    "ingresado boolean," +
                    "visitas boolean," +
                    "PRIMARY KEY ( dni )," +
                    "FOREIGN KEY (habitacion) references habitacion(numero)," +
                    "FOREIGN KEY (consulta) references consulta(numero))";
            statement.executeUpdate(table);
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createTableEmpleado() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");
            statement = conn.createStatement();
            String table = "CREATE TABLE empleado " +
                    "(dni VARCHAR(9) not NULL," +
                    "nombre VARCHAR(50), " +
                    "apellidos VARCHAR(200)," + "tipo VARCHAR(99)," +
                    "PRIMARY KEY ( dni ))";
            statement.executeUpdate(table);
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void selectAllPacientes() {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT dni,nombre,apellidos,numeroRegistro FROM paciente ";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String numRegi = rs.getString("numeroRegistro");

                System.out.println("*" + numRegi + "*");
                System.out.println("DNI : " + dni);
                System.out.println("Apellidos : " + apellidos);
                System.out.println("Nombre : " + nombre);
                System.out.println("------------");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insertPaciente() {
        System.out.println("Escribe el dni del paciente a insertar");
        Scanner ns = new Scanner(System.in);
        String dni = ns.nextLine();

        System.out.println("Escribe el nombre del paciente a insertar");
        Scanner oc = new Scanner(System.in);
        String nombre = oc.nextLine();

        System.out.println("Escribe los apellidos del paciente a insertar");
        Scanner li = new Scanner(System.in);
        String apellidos = li.nextLine();

        System.out.println("Escribe el número para asignar al paciente");
        Scanner pa = new Scanner(System.in);
        String numeroAsig = pa.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("INSERT INTO paciente(dni,nombre,apellidos,numeroRegistro) VALUES (?,?,?,?)");
                st.setString(1, dni);
                st.setString(2, nombre);
                st.setString(3, apellidos);
                st.setString(4, numeroAsig);

                st.executeUpdate();
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void darComida() {
        System.out.println("Introduce el dni del paciente");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        System.out.println("¿Qué comida le vas a llevar al paciente?");
        Scanner ns = new Scanner(System.in);
        String comida = ns.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("update paciente set comida = ? where dni = ?"); //Aqui nose si tengo q meter la ? en ''
                st.setString(1, comida);
                st.setString(2, dni);

                st.executeUpdate();
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void mandarTratamiento() {
        System.out.println("Introduce el dni del paciente");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        System.out.println("¿Qué tratamiento le vas a mandar al paciente?");
        Scanner ns = new Scanner(System.in);
        String tratamiento = ns.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("update paciente set tratamiento = ? where dni = ?"); //Aqui nose si tengo q meter la ? en ''
                st.setString(1, tratamiento);
                st.setString(2, dni);

                st.executeUpdate();
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void transportarPaciente() {
        System.out.println("Introduce el dni del paciente");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        System.out.println("Introduce el número de habitación donde llevar al paciente.");
        Scanner ns = new Scanner(System.in);
        int numero = ns.nextInt();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("update paciente set habitacion = ? where dni = ?"); //Aqui nose si tengo q meter la ? en ''
                st.setInt(1, numero);
                st.setString(2, dni);

                st.executeUpdate();
                st.close();
                System.out.println("El paciente se ha trasladado a la habitación" + numero);
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void darAltaPaciente() {
        System.out.println("Introduce el dni del paciente para dar de alta.");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("delete from paciente where dni = ?");
                st.setString(1, dni);

                st.executeUpdate();
                st.close();
                System.out.println("El paciente con el dni: " + dni + " ha sido dado de alta.");
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
    public void insertEmpleado() {
        System.out.println("Escribe el dni del empleado a insertar");
        Scanner ns = new Scanner(System.in);
        String dni = ns.nextLine();

        System.out.println("Escribe el nombre del empleado a insertar");
        Scanner oc = new Scanner(System.in);
        String nombre = oc.nextLine();

        System.out.println("Escribe los apellidos del empleado a insertar");
        Scanner li = new Scanner(System.in);
        String apellidos = li.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("INSERT INTO empleado(dni,nombre,apellidos) VALUES (?,?,?)");
                st.setString(1, dni);
                st.setString(2, nombre);
                st.setString(3, apellidos);

                st.executeUpdate();
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void despedirEmpleado() {
        System.out.println("Introduce el dni del empleado para despedir.");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, USUARIO, CLAVE);
            if (!conn.isClosed()) System.out.println("Conexion realizada...");

            try {
                PreparedStatement st = conn.prepareStatement("delete from empleado where dni = ?"); //Aqui nose si tengo q meter la ? en ''
                st.setString(1, dni);

                st.executeUpdate();
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception");
                System.err.println(e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
*/
    public static void main(String args[]) throws SQLException, ClassNotFoundException {


    }

}

