/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.dao;
import examen.entities.MiError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 06/12/2017
 **/
public class Conexion {
    public static final String DRIVER = "jdbc:postgresql://";
    public static final String SERVER = "localhost:5432/";
    public static final String DB = "examen";
    public static final String USER = "postgres";
    public static final String PASS = "postgres";
    /**
     * Método que se encarga de conectar con la BD
     * @return Connection conn
     */
    public static Connection getConexion() {
        Connection conn = null;
        String url = DRIVER + SERVER + DB;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, USER, PASS);
            //System.out.println("Conexión  con éxito!!"); //TODO: Eliminar linea
        } catch (ClassNotFoundException ex) {
            throw new MiError("Falta el driver de base de datos.");
        } catch (SQLException ex) {
            throw new MiError("Problemas al realizar la conexión.\n" + ex.getMessage());
        }
        return conn;
    }
}
