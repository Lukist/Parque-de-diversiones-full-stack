

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/test.css" rel="stylesheet" type="text/css"/>
        <link href="Css/linkStyle.css" rel="stylesheet" type="text/css"/>
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
             
        <h1 class="title">Bienvenido al Sistema</h1> <br>
        
        <a href="modificarCuenta.jsp" class="link">| Modificar cuenta |</a> <br>
                
                
        <a href="gestionAtracciones.jsp" class="link">| Ir a gestión de atracciones |</a> <br>
                
                
        <a href="gestionHorarios.jsp" class="link">| Ir a gestión de horarios |</a> <br>
                
               
        <a href="gestionEntradas.jsp" class="link">| Venta de Entradas |</a> <br>
                
                
        <a href="registrarCliente.jsp" class="link">| Registrar cliente |</a> <br>
        
        
        <a href="gestionCliente.jsp" class="link">| Ir a gestion de cliente |</a> <br>
               
                
        <a href="estadisticas.jsp" class="link">| Estadisticas |</a>
        
        
        
               
    
        </div>

    
    
    <%} else {
      
      response.sendRedirect("errorAcceso.jsp");

    }%>
    </body>
</html>
