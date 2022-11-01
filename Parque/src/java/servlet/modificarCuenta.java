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
import logica.Encargado;
import logica.Usuario;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "modificarCuenta", urlPatterns = {"/modificarCuenta"})
public class modificarCuenta extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Controladora controladora = new Controladora();
    
            try {
                long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
                long idEncargado = Long.parseLong(request.getParameter("idEncargado"));
                String nombreUsuario = request.getParameter("nombreUsuario");
                String clave = request.getParameter("clave");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                long atraccion = Long.parseLong(request.getParameter("Atraccion"));

            controladora.modificarCuenta(idUsuario, idEncargado, nombreUsuario, clave, nombre, apellido, atraccion);

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
