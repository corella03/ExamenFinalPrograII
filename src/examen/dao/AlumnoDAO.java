/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.dao;
import examen.entities.Alumno;
import examen.entities.MiError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 06/12/2017
 **/
public class AlumnoDAO {
    /**
     * Método para registar un Alumno es la BD
     * @param alumno Alumno que se va a registar
     * @return true si se conecto con la BD y se Registro, throw si hubo algún tipo de Error.
     */
    public boolean insertarAlumno(Alumno alumno) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into alumnos(cedula, nombre, apellido)"
                    + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, alumno.getCedula());
            stmt.setString(2, alumno.getNombre());
            stmt.setString(3, alumno.getApellido());
            return stmt.executeUpdate() > 0;
        }
//        catch(SQLException e) {
//            throw  new MiError("El codigo de la agencia ya fue registrada.");
//        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar al Alumno, favor intente nuevamente.");
        }
    }
    /**
     * Método que se encarga de todos los alumnos registrados en la BD
     * @return ArrayList Con los alumnos registardos.
     */
    public ArrayList<Alumno> cargarAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from alumnos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                alumnos.add(cargarAlumno(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los Alumnos, favor intente nuevamente.");
        }
        return alumnos;
    }
    /**
     *  Método para llenar los datos de cada alumno en la entidad Alumno
     * @param rs  
     * @return Alumno: Datos del alumno
     * @throws SQLException 
     */
    private Alumno cargarAlumno(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setId(rs.getInt("id"));
        alumno.setCedula(rs.getString("cedula"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido(rs.getString("apellido"));
        return alumno;    
    }
}