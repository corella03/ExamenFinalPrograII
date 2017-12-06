/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entities;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 06/12/2017
 **/
public class Alumno {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    public Alumno() {
    }
    public Alumno(int id, String cedula, String nombre, String apellido) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     *Método toString de Alumno que devuelve datos en forma de String.
     * @return String con los datos de Alumno
     */
    @Override
    public String toString() {
        return "Alunmo Cédula: "+cedula+ "\nNombre: " + nombre + "\nApellido: " + apellido;
    }
    
}