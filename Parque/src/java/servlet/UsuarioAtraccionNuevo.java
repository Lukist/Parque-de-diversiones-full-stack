/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static logica.Atraccion_.nombreAtraccion;
import static logica.Encargado_.apellido;
import static logica.Encargado_.nombre;
import static logica.Usuario_.clave;
import static logica.Usuario_.nombreUsuario;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "UsuarioAtraccionNuevo", urlPatterns = {"/UsuarioAtraccionNuevo"})
public class UsuarioAtraccionNuevo extends HttpServlet {
    

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        
        try {
            String nombreUsuario = request.getParameter("nombreUsuario");
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        String nombreAtraccion = request.getParameter("nombreAtraccion");
        int capacidadMaxima = Integer.parseInt(request.getParameter("capacidadMax"));
        int capacidadMinima = Integer.parseInt(request.getParameter("capacidadMin"));
        
        boolean mayoriaDeEdad = Boolean.parseBoolean(request.getParameter("mayoriaEdad"));
        
        String horaIda = request.getParameter("horaIda");
        String horaVuelta = request.getParameter("horaVuelta");
        
        control.nuevoUsuarioAtraccion(nombreUsuario, clave, nombre, apellido, nombreAtraccion, capacidadMaxima, capacidadMinima, true, horaIda, horaVuelta);
        
        response.sendRedirect("exitazo.jsp");
        } catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
