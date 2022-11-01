<%-- 
    Document   : modificarCuenta
    Created on : 22/09/2022, 14:39:33
    Author     : Lucas
--%>

<%@page import="persistencia.Controladora"%>
<%@page import="logica.Encargado"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/linkStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");
      Encargado enc = (Encargado) sesion.getAttribute("encargadoUsuario");

      if (usuario != null) {
        
        
    %>
    <div class="container">
        <h1 class="title">Modificar usuario</h1>
    <form method="POST" action="modificarCuenta" autocomplete="off">
        <div class="form-control">
        <label for="id">ID Usuario:</label>
        <br>
        <input type="number" id="id" name="idUsuario" readonly value="<%=usuario.getIdUsuario()%>">
      </div>
      
      <div class="form-control"> 
        <label for="idEncargado">Id Encargado:</label>
        <br>
        <input type="number" id="idEncargado" name="idEncargado" readonly value="<%=enc.getIdEncargado()%>">
      </div>
      
      <div class="form-control">
        <label for="nombreUsuario">Nombre Usuario:</label>
        <br>
        <input type="text" id="nombreUsuario" name="nombreUsuario" value="<%=usuario.getNombreUsuario()%>">
      </div>
      <div class="form-control">
          <input type="text" id="clave" name="clave" value="" required="">
        <label>
            <span style="transition-delay:0ms">C</span><span style="transition-delay:50ms">l</span><span style="transition-delay:100ms">a</span><span style="transition-delay:150ms">v</span><span style="transition-delay:200ms">e</span>
        </label>
      </div>
      
      <div class="form-control">
        <label for="nombre">Nombre:</label>
        <br>
        <input type="text" id="nombre" name="nombre" value="<%=enc.getNombre()%>">
      </div>
      
      <div class="form-control">
        <label for="apellido">Apellido:</label>
        <br>
        <input type="text" id="apellido" name="apellido" value="<%=enc.getApellido()%>">
      </div>
      
      <div class="form-control">
        <label for="Atraccion">Atraccion:</label>
        <br>
        <input type="number" id="Atraccion" name="Atraccion" value=<%if (enc.getAtr() != null) {
            out.print(enc.getAtr().getIdAtraccion());
        } else {
            out.print("");
        }%>>
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
