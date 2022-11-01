<%-- 
    Document   : ventaEntradas
    Created on : 22/09/2022, 03:50:36
    Author     : Lucas
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Horario"%>
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Cliente"%>
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
          Atraccion atr = (Atraccion) sesion.getAttribute("atraccionElegida");
          Cliente cli = (Cliente) sesion.getAttribute("clienteTarjeta");
    %>
    <div class="container">
        <h1 class="pageTitle">Venta de Entradas</h1>
    
        <form method="POST" action="ventaEntradas" autocomplete="off">
            <div class="form-control">
                <label for="atraccion">Atraccion Id:</label> <br>
            <input type="number" id="atraccion"  readonly name="atraccion" value="<%=atr.getIdAtraccion()%>">
          </div>
          <div class="form-control">
            <label for="tarjeta">Id tarjeta:</label><br>
            <input type="number" id="tarjeta" readonly name="tarjeta" value="<%=cli.getIdTarjeta()%>">
          </div>
          <div class="form-control">
              <label for="dia">Dia a Ir:</label> <br>
            <input type="date" id="horaFin" name="dia" value="">
          </div>
          <div class="form-control">
              <input type="number" id="Id_horario" name="Id_horario" value="" required="">
            <label>
                <span style="transition-delay:0ms">I</span><span style="transition-delay:50ms">D</span><span style="transition-delay:100ms"> </span><span style="transition-delay:150ms">H</span><span style="transition-delay:200ms">o</span><span style="transition-delay:250ms">r</span><span style="transition-delay:300ms">a</span><span style="transition-delay:350ms">r</span><span style="transition-delay:400ms">i</span><span style="transition-delay:450ms">o</span>
            </label>
          </div>
          <div>
              <input type="submit" value="Comprar" class="submit">
          </div>
        </form>
        
    </div>
    <div class="tableDiv">
        <h2 class="subTitle">Listado de horarios</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Hora principio</th>
              <th>Hora final</th>
              <th>Atraccion</th>
            </tr>
          </thead>
          <tbody>
            <%
              Controladora controladora = (Controladora) sesion.getAttribute("controladora");

              List<Horario> listaHorarios = controladora.encontrarHorarios();

              for (Horario hor : listaHorarios) {
                  if (hor.getAtra().getIdAtraccion() == atr.getIdAtraccion()) {


            %>

            <tr>
              <td><%=hor.getIdHorario()%></td>
              <td><%=hor.getPrincipio()%></td>
              <td><%=hor.getFin()%></td>
              <%
              if (hor.getAtra() != null) {
                  out.println(String.format("<td>%s</td>", hor.getAtra().getNombreAtraccion()));
              } else {
                  out.println(String.format("<td>%s</td>", "¿?"));
              }
              %>
            </tr>
            <%} }%>
          </tbody>
        </table>       
              
    </div>
    
    <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
