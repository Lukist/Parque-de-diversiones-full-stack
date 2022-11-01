/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Controladora;


@WebServlet(name = "registrationComplete", urlPatterns = {"/registrationComplete"})
public class registrationComplete extends HttpServlet {

    
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
        
        try {
            control.nuevoUsuario(nombreUsuario, clave, nombre, apellido, nombreAtraccion);
        } catch (Exception ex) {
            Logger.getLogger(registrationComplete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("exitazo.jsp");
        } catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
