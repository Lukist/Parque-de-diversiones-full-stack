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
import logica.Atraccion;
import logica.Cliente;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "estadisticas", urlPatterns = {"/estadisticas"})
public class estadisticas extends HttpServlet {

    

    



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Controladora controladora = new Controladora();
    
            try {
                long idAtraccion = Long.parseLong(request.getParameter("atraccion"));
                String dia = request.getParameter("dia");

                Atraccion atraccionEstadistica = controladora.encontrarAtraccion(idAtraccion);



                HttpSession sesion = request.getSession();

                sesion.setAttribute("atraccionEstadistica", atraccionEstadistica);
                sesion.setAttribute("dia", dia);

                response.sendRedirect("estadisticaResultado.jsp");
            } catch (Exception e) {
                response.sendRedirect("Error.jsp");
            }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
