<%-- 
    Document   : gestionCliente
    Created on : 24/09/2022, 17:39:45
    Author     : Lucas
--%>

<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="logica.Atraccion"%>
<%@page import="persistencia.Controladora"%>
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
    %>
    
    <h1 class="pageTitle">Clientes</h1>
    
    <div class="container">
        
        

        <form method="GET" action="modificarCliente" autocomplete="off">
          <h3 class="subTitle">Modificar Cliente:</h3>
          
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
        <form method="POST" action="eliminarCliente" autocomplete="off">
          <h3 class="subTitle">Eliminar Cliente:</h3>
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
        
    <h2 class="tableTitle">Cliente</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Apellido</th>
        </tr>
      </thead>
      <tbody>
        <%
          Controladora controladora = (Controladora) sesion.getAttribute("controladora");

          List<Cliente> listaClientes = controladora.encontrarClientes();

          for (Cliente cli : listaClientes) {
        %>

        <tr>
          <td><%=cli.getIdTarjeta()%></td>
          <td><%=cli.getNombre()%></td>
          <td><%=cli.getApellido()%></td>
        </tr>

        <%}%>
      </tbody>
        
    </div>
    
    </table>
    <%} else {

      response.sendRedirect("errorAcceso.jsp");

    }%>
    </body>
</html>
