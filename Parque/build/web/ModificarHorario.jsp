<%-- 
    Document   : UsuarioModificar
    Created on : 21/09/2022, 17:19:32
    Author     : Lucas
--%>

<%@page import="java.util.List"%>
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Atraccion"%>
<%@page import="logica.Horario"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/detalles.css" rel="stylesheet" type="text/css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {
        
      Horario usr = (Horario) sesion.getAttribute("horarioModificar");
    %>
    
    <div class="container">
        
        
        <h1 class="subTitle">Modificar horario</h1>
    <form method="POST" action="modificarHorario" autocomplete="off">
        <div class="form-control">
            <label for="id">ID:</label> <br>
        <input type="text" id="id" name="id" readonly value="<%=usr.getIdHorario()%>">
      </div>
      <div class="form-control">
        <label for="horaPrincipio">Hora Principio:</label><br>
        <input type="time" id="horaPrincipio" name="horaPrincipio" value="<%=usr.getPrincipio()%>">
      </div>
      <div class="form-control">
        <label for="horaFin">Hora Fin:</label><br>
        <input type="time" id="horaFin" name="horaFin" value="<%=usr.getFin()%>">
      </div>
      <div class="form-control">
        <label for="Atraccion">Atraccion:</label><br>
        <input type="number" id="Atraccion" name="Atraccion" value=<%if (usr.getAtra() != null) {
            out.print(usr.getAtra().getIdAtraccion());
        } else {
            out.print("");
        }%>>
      </div>
      <div>
          <input type="submit" value="Modificar" class="submit">
      </div>
    </form>
        
    </div>
    
      
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Capacidad Maxima</th>
          <th>Capacidad Minima</th>
          <th>Mayoria de Edad</th>
          <th>Nombre Atraccion</th>
        </tr>
      </thead>
      <tbody>
        <%
          Controladora controladora = (Controladora) sesion.getAttribute("controladora");

          List<Atraccion> listaAtracciones = controladora.encontrarAtracciones();

          for (Atraccion atr : listaAtracciones) {
        %>

        <tr>
          <td><%=atr.getIdAtraccion()%></td>
          <td><%=atr.getCapacidadMaxima()%></td>
          <td><%=atr.getCapacidadMinima()%></td>
          <td><%=atr.isMayoriaDeEdad()%></td>
          <td><%=atr.getNombreAtraccion()%></td>
        </tr>

        <%}%>
      </tbody>
    </table>
    <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
