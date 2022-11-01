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
@WebServlet(name = "ventaEntradas", urlPatterns = {"/ventaEntradas"})
public class ventaEntradas extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
    
        try {
            long idAtraccion = Long.parseLong(request.getParameter("idAtraccion"));
            long idTarjeta = Long.parseLong(request.getParameter("idTarjeta"));

            Atraccion atraccionElegida = controladora.encontrarAtraccion(idAtraccion);
            
            Cliente clienteTarjeta = controladora.encontrarCliente(idTarjeta);

            HttpSession sesion = request.getSession();

            sesion.setAttribute("atraccionElegida", atraccionElegida);
            sesion.setAttribute("clienteTarjeta", clienteTarjeta);

            response.sendRedirect("ventaEntradas.jsp");
        } catch (Exception e) {
            response.sendRedirect("Error.jsp");
        }
            
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
    
            long idAtraccion = Long.parseLong(request.getParameter("atraccion"));
            long idTarjeta = Long.parseLong(request.getParameter("tarjeta"));
            String dia = request.getParameter("dia");
            long horario = Long.parseLong(request.getParameter("Id_horario"));
            
            controladora.venderEntrada(idAtraccion, idTarjeta, horario, dia);
            
            response.sendRedirect("exitazo.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
