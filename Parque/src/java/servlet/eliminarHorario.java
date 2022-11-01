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
import logica.Horario;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "eliminarHorario", urlPatterns = {"/eliminarHorario"})
public class eliminarHorario extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        Controladora controladora = new Controladora();
    
        try {
            long id = Long.parseLong(request.getParameter("id"));

            controladora.eliminarHorario(id);

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
