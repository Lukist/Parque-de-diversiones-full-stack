<%-- 
    Document   : estadisticas
    Created on : 22/09/2022, 06:25:21
    Author     : Lucas
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Atraccion"%>
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/detalles.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {

    %>
   
    <div class="container">
         <h1 class="pageTitle">Estadisticas</h1>
        <form method="POST" action="estadisticas" autocomplete="off">
        <div class="form-control">
            <input type="number" id="hatraccion" name="atraccion" value="" required="">
        <label>
            <span style="transition-delay:0ms">A</span><span style="transition-delay:50ms">t</span><span style="transition-delay:100ms">r</span><span style="transition-delay:150ms">a</span><span style="transition-delay:200ms">c</span><span style="transition-delay:250ms">c</span><span style="transition-delay:300ms">i</span><span style="transition-delay:350ms">o</span><span style="transition-delay:350ms">n</span>
        </label>
        </div>
      
        
        <div class="form-control">
            <label for="dia">Dia:</label><br>
            <input type="date" id="dia" name="dia" value="">
        </div>
      <div>
          <input type="submit" value="Modificar" class="submit">
      </div>
    </form>
    </div>
    
    </div>
    <div class="tableDiv">
        
    <h2 class="tableTitle">Listado de Atracciones</h2>
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
        
    </div>
    
    </table>
    
    
    
    <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
