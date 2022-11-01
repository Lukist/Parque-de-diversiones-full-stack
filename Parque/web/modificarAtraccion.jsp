
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Atraccion"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/detalles.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {
        
      Atraccion atr = (Atraccion) sesion.getAttribute("atraccionModificar");
    %>
    
    <div class="container">
        <h1 class="subTitle">Modificar usuario</h1>
    
        <form method="POST" action="modificarAtraccion" autocomplete="off">
          <div class="form-control">
              <label for="id">ID:</label> <br>
            <input type="text" id="id" name="id" readonly value="<%=atr.getIdAtraccion()%>">
          </div>
          <div class="form-control">
            <label for="capacidadMax">Capacidad Maxima:</label><br>
            <input type="number" id="capacidadMax" name="capacidadMax" value="<%=atr.getCapacidadMaxima()%>">
          </div>
          <div class="form-control">
            <label for="capacidadMin">Capacidad Minima:</label><br>
            <input type="number" id="capacidadMin" name="capacidadMin" value="<%=atr.getCapacidadMinima()%>">
          </div>

          <div class="chekBox">
            <label class="checkTitle">Mayoria de Edad</label><br>
            <input type="radio" name="mayoriaEdad" id="mayoriaEdad" required="" value="true">
            <label for="mayoriaEdad">Si</label>
            <input type="radio" name="mayoriaEdad" id="minoriaEdad" required="" value="false">
            <label for="minoriaEdad">No</label>
          </div>
          <div class="form-control">
            <label for="nombreAtraccion">Nombre Atraccion:</label><br>
            <input type="text" id="nombreAtraccion" name="nombreAtraccion" value="<%=atr.getNombreAtraccion()%>">
          </div>
          <div>
              <input type="submit" value="Modificar" class="submit">
          </div>
    </form>   
    </div>
    
      <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
