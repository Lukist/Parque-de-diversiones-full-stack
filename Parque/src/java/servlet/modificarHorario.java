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
import logica.Usuario;
import persistencia.Controladora;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "modificarHorario", urlPatterns = {"/modificarHorario"})
public class modificarHorario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Controladora controladora = new Controladora();
    
    long id = Long.parseLong(request.getParameter("id"));
    
    Horario horarioModificar = controladora.encontrarHorario(id);
    
    HttpSession sesion = request.getSession();
    
    sesion.setAttribute("horarioModificar", horarioModificar);
    
    response.sendRedirect("ModificarHorario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
    
        try {
            long id = Long.parseLong(request.getParameter("id"));
        String horaPrincipio = request.getParameter("horaPrincipio");
        String horaFin = request.getParameter("horaFin");
        long atraccion = Long.parseLong(request.getParameter("Atraccion"));

        controladora.modificarHorario(id, horaPrincipio, horaFin, atraccion);

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
