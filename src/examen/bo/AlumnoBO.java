/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;
import examen.dao.AlumnoDAO;
import examen.entities.Alumno;
import examen.entities.MiError;
import java.util.ArrayList;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 06/12/2017
 **/
public class AlumnoBO {
    private AlumnoDAO alumnodao;
    public AlumnoBO() {
        alumnodao = new AlumnoDAO();
    }
    /**
     * Método para verificar datos del Alumno y enviarlo al registro de alumnosDAO.
     * @param alumno alumno que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarAlumno(Alumno alumno) {
        if (alumno.getCedula().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la cédula del Alumno.");
        }
        if (alumno.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del Alumno.");
        }
        if (alumno.getApellido().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el apellido del Alumno.");
        }
        return alumnodao.insertarAlumno(alumno);
    }
    /**
     * Método para cargar los usuarios que vienen del alumnoDAO
     * @return Alumno: la lista de los alumnos.
     */
    public ArrayList<Alumno> cargarAlumnos(){
        return alumnodao.cargarAlumnos();
    }
}