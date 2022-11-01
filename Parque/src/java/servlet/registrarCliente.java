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
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "registrarCliente", urlPatterns = {"/registrarCliente"})
public class registrarCliente extends HttpServlet {
    
    

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
    
        try {
            
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        

        controladora.crearCliente(nombre, apellido);

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
