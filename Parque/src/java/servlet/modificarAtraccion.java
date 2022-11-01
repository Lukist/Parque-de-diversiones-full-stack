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
import logica.Horario;
import persistencia.Controladora;


@WebServlet(name = "modificarAtraccion", urlPatterns = {"/modificarAtraccion"})
public class modificarAtraccion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Controladora controladora = new Controladora();
    
            try {
                long id = Long.parseLong(request.getParameter("id"));

                Atraccion atraccionModificar = controladora.encontrarAtraccion(id);

                HttpSession sesion = request.getSession();

                sesion.setAttribute("atraccionModificar", atraccionModificar);

                response.sendRedirect("modificarAtraccion.jsp");
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
                int capacidadMax = Integer.parseInt(request.getParameter("capacidadMax"));
                int capacidadMin = Integer.parseInt(request.getParameter("capacidadMin"));
                boolean mayoriaDeEdad = Boolean.parseBoolean(request.getParameter("mayoriaEdad"));
                String nombreAtraccion = request.getParameter("nombreAtraccion");

                controladora.editarAtraccion(id, nombreAtraccion, capacidadMax, capacidadMin, mayoriaDeEdad);

                response.sendRedirect("exitazo.jsp");
            } catch (Exception e) {
                response.sendRedirect("LoginError.jsp");
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
