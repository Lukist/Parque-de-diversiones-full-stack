/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "UsuarioLogin", urlPatterns = {"/UsuarioLogin"})
public class UsuarioLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Controladora controladora = new Controladora();
    
        String nombreUsuario = request.getParameter("nombreUsuario");
        String clave = request.getParameter("clave");

        Usuario usuario;
        Encargado encargado = new Encargado();
        usuario = controladora.loginUsuario(nombreUsuario, clave);
        
        if (usuario != null) {
          List<Encargado> listaEncargados = controladora.encontrarEncargados();
          
          for (Encargado enc : listaEncargados) {
              if(enc.getUser().getIdUsuario() == usuario.getIdUsuario()) {
                  encargado = enc;
              }
          }
          
          HttpSession sesion = request.getSession(true);

          sesion.setAttribute("controladora", controladora);
          sesion.setAttribute("usuarioValidado", usuario);
          sesion.setAttribute("encargadoUsuario", encargado);

          response.sendRedirect("hall.jsp");

        } else {

          response.sendRedirect("LoginError.jsp");

        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
