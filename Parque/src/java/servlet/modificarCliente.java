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
import javax.servlet.http.HttpSession;
import logica.Cliente;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "modificarCliente", urlPatterns = {"/modificarCliente"})
public class modificarCliente extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
        
        try {
            long id = Long.parseLong(request.getParameter("id"));
        
            Cliente clienteModificar = controladora.encontrarCliente(id);

            HttpSession sesion = request.getSession();

            sesion.setAttribute("clienteModificar", clienteModificar);

            response.sendRedirect("modificarCliente.jsp");
            
        } catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
        
        try {
            long id = Long.parseLong(request.getParameter("id"));
        
        String nombre = request.getParameter("nombre");
        
        String apellido = request.getParameter("apellido");
        
        controladora.editarCliente(id, nombre, apellido);
        
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
