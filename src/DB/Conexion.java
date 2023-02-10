package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Conexion {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/hospital_bd";
    public static void main(String args[]) throws SQLException {
        final String usuario = "root";
        final String password = "";
        Connection dbConnection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            if (!conn.isClosed() ) System.out.println("Conexion realizada...");

            String selectTableSQL = "SELECT numero,material,tipo FROM lista_consultas ";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String num = rs.getString("numero");
                String mat = rs.getString("material");
                String tip = rs.getString("tipo");

                System.out.println("------------");
                System.out.println("Consulta numero : " + num);
                System.out.println("Material : " + mat);
                System.out.println("Tipo de consulta : " + tip);



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
          /*  if (statement != null) {
                statement.close();
            } */
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}

