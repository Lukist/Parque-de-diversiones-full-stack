
<%@page import="java.util.List"%>
<%@page import="logica.Atraccion"%>
<%@page import="logica.Atraccion"%>
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {

    %>
    <h1>Modificar usuario</h1>
    <form method="POST" action="crearHorario" autocomplete="off">
      <div>
        <label for="horaPrincipio">Hora Principio:</label>
        <input type="time" id="horaPrincipio" name="horaPrincipio" value="">
      </div>
      <div>
        <label for="horaFin">Hora Fin:</label>
        <input type="time" id="horaFin" name="horaFin" value="">
      </div>
      <div>
        <label for="Atraccion">Atraccion:</label>
        <input type="number" id="Atraccion" name="Atraccion" value="">
      </div>
      <div>
        <input type="submit" value="Modificar">
      </div>
    </form>
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
