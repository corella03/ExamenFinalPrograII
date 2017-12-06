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
public class MiError extends RuntimeException{
    public MiError() {
    }
    public MiError(String string) {
        super(string);
    }
}