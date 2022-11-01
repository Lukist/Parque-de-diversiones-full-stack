
<%@page import="logica.Atraccion"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.Controladora"%>
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
    %>
    
    <h1 class="pageTitle">Gestión de Atracciones</h1>
    
    <div class="container">
        
        

        <form method="GET" action="modificarAtraccion" autocomplete="off">
          <h3 class="subTitle">Modificar atraccion:</h3>
          
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
        <form method="POST" action="eliminarAtraccion" autocomplete="off">
          <h3 class="subTitle">Eliminar Atraccion:</h3>
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

      response.sendRedirect("errorAcceso.jsp");

    }%>
    
    
    </body>
</html>
