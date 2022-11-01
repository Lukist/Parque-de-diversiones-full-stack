<%-- 
    Document   : gestionHorarios
    Created on : 21/09/2022, 16:49:53
    Author     : Lucas
--%>

<%@page import="logica.Atraccion"%>
<%@page import="logica.Horario"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/linkStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/detalles.css" rel="stylesheet" type="text/css"/>
        <link href="Css/test.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
      /*acá escribimos código Java*/
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {
    %>
    <h1 class="pageTitle">Gestión de horarios</h1>
    <div class="container">
        
    <h3 class="subTitle">Crear Horario</h3>
    
    <a href="crearHorario.jsp">Crear</a>
    <form method="GET" action="modificarHorario" autocomplete="off">
        <h3 class="subTitle">Modificar horario:</h3>
      
      <div class="form-control">
        <input type="text" id="id" name="id" required="">
        <label>
            <span style="transition-delay:0ms">I</span><span style="transition-delay:50ms">D</span>
        </label>
      </div>
      <input type="submit" value="Modificar" class="submit">
    </form>
    <br>
    <br>
    <form method="POST" action="eliminarHorario" autocomplete="off">
        <h3 class="subTitle">Eliminar horario:</h3>
      
      <div class="form-control">
        <input type="text" id="id" name="id" required=""> 
        <label>
            <span style="transition-delay:0ms">I</span><span style="transition-delay:50ms">D</span>
        </label>
      </div>
      <input type="submit" value="Eliminar" class="submit">
    
    </form>
        
    </div>
    <div class="tableDiv">
        <h2 class="tableTitle">Listado de horarios</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Hora principio</th>
              <th>Hora final</th>
              <th>Atraccion</th>
            </tr>
          </thead>
          <tbody>
            <%
              Controladora controladora = (Controladora) sesion.getAttribute("controladora");

              List<Horario> listaHorarios = controladora.encontrarHorarios();

              for (Horario hor : listaHorarios) {
            %>

            <tr>
              <td><%=hor.getIdHorario()%></td>
              <td><%=hor.getPrincipio()%></td>
              <td><%=hor.getFin()%></td>
              <%
              if (hor.getAtra() != null) {
                  out.println(String.format("<td>%s</td>", hor.getAtra().getNombreAtraccion()));
              } else {
                  out.println(String.format("<td>%s</td>", "¿?"));
              }
              %>
            </tr>
            <%}%>
          </tbody>
        </table>
    </div>
   
    <%} else {

      response.sendRedirect("errorAcceso.jsp");

    }%>
    </body>
</html>
