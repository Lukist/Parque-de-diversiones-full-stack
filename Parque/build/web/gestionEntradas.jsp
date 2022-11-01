
<%@page import="logica.Usuario"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="logica.Atraccion"%>
<%@page import="logica.Atraccion"%>
<%@page import="persistencia.Controladora"%>
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
    <h1 class="pageTitle">Compra de Entradas</h1>
    
    
    <form method="GET" action="ventaEntradas" autocomplete="off">
      <h3 class="subTitle">Atraccion a comprar:</h3>
      <div class="form-control">
          <input type="text" id="idAtraccion" name="idAtraccion" required="">
        <label>
            <span style="transition-delay:0ms">I</span><span style="transition-delay:50ms">D</span><span style="transition-delay:100ms"> </span><span style="transition-delay:150ms">J</span><span style="transition-delay:200ms">u</span><span style="transition-delay:250ms">e</span><span style="transition-delay:300ms">g</span><span style="transition-delay:350ms">o</span>
        </label>
      </div>

      <div class="form-control"> 
          <input type="text" id="idTarjeta" name="idTarjeta" required="">
        <label>
            <span style="transition-delay:0ms">I</span><span style="transition-delay:50ms">D</span><span style="transition-delay:100ms"> </span><span style="transition-delay:150ms">T</span><span style="transition-delay:200ms">a</span><span style="transition-delay:250ms">r</span><span style="transition-delay:300ms">j</span><span style="transition-delay:350ms">e</span><span style="transition-delay:350ms">t</span><span style="transition-delay:350ms">a</span>
        </label>
      </div>
      
      
      <input type="submit" value="Comprar" class="submit">
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

      response.sendRedirect("errorAcceso.jsp");

    }%>
    </body>
</html>
