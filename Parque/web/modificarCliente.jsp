<%-- 
    Document   : modificarCliente
    Created on : 24/09/2022, 18:19:11
    Author     : Lucas
--%>

<%@page import="logica.Usuario"%>
<%@page import="logica.Cliente"%>
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
        
      Cliente cli = (Cliente) sesion.getAttribute("clienteModificar");
    %>
    
    <div class="container">
        
        
        <h1 class="subTitle">Modificar usuario</h1>
    <form method="POST" action="modificarCliente" autocomplete="off">
        <div class="form-control">
            <label for="id">ID:</label> <br>
        <input type="text" id="id" name="id" readonly value="<%=cli.getIdTarjeta()%>">
      </div>
      <div class="form-control">
        <label for="horaPrincipio">Nombre:</label><br>
        <input type="text" id="horaPrincipio" name="nombre" value="<%=cli.getNombre()%>">
      </div>
      <div class="form-control">
        <label for="horaFin">Apellido:</label><br>
        <input type="text" id="horaFin" name="apellido" value="<%=cli.getApellido()%>">
      </div>
      <div>
          <input type="submit" value="Modificar" class="submit">
      </div>
    </form>
        
    </div>
      
      <%} else {

      response.sendRedirect("errorAcceso.jsp");

    }%>
    </body>
</html>
