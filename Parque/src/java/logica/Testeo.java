/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.Controladora;
import java.util.ArrayList;
import java.util.LinkedList;
import persistencia.ClienteJpaController;
import persistencia.EntradaJpaController;

public class Testeo {
    public static void main(String[] args) {
        Controladora controladora = new Controladora();
        Usuario usuario = controladora.encontrarUsusario(9);
        
        Encargado encargado = controladora.encontrarEncargado(usuario.getIdUsuario());
        
        System.out.println("Hola " + encargado.getNombre());
        
        
        
    }
}
