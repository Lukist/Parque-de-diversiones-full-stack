<%-- 
    Document   : registrarCliente
    Created on : 22/09/2022, 03:52:02
    Author     : Lucas
--%>

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
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

    %>
    <div class="container">
        <h1 class="title">Registrar Cliente</h1>
    <form method="POST" action="registrarCliente" autocomplete="off">
        <div class="form-control">
            <input type="text" id="apellido" name="nombre" value="" required="">
        <label>
            <span style="transition-delay:0ms">N</span><span style="transition-delay:50ms">o</span><span style="transition-delay:100ms">m</span><span style="transition-delay:150ms">b</span><span style="transition-delay:200ms">r</span><span style="transition-delay:250ms">e</span>
        </label>
      </div>
        <div class="form-control">
            <input type="text" id="apellido" name="apellido" value="" required="">
        <label>
            <span style="transition-delay:0ms">A</span><span style="transition-delay:50ms">p</span><span style="transition-delay:100ms">e</span><span style="transition-delay:150ms">l</span><span style="transition-delay:200ms">l</span><span style="transition-delay:250ms">i</span><span style="transition-delay:300ms">d</span><span style="transition-delay:350ms">o</span>
        </label>
      </div>
      <div>
          <input type="submit" value="Registrar" class="submit">
      </div>
    </form>
        
    </div>
    
    <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
