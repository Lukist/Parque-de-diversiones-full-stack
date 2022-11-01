<%-- 
    Document   : estadisticaResultado
    Created on : 22/09/2022, 06:40:08
    Author     : Lucas
--%>

<%@page import="logica.Encargado"%>
<%@page import="logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.Controladora"%>
<%@page import="logica.Atraccion"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/detalles.css" rel="stylesheet" type="text/css"/>
        <link href="Css/linkStyle.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {
        
      Atraccion atr = (Atraccion) sesion.getAttribute("atraccionEstadistica");
      String dia = (String) sesion.getAttribute("dia");
    %>
    
    <div>
        <table>
            <caption>Entradas vendidas todos los juegos el <%=dia%>:</caption>
      <thead>
        <tr>
          <th>ID</th>
          <th>Dia</th>
          <th>Id Tarjeta</th>
          <th>Nombre Atraccion</th>
          <th>Horario Entrada</th>
          <th>Horario Salida</th>
        </tr>
      </thead>
      <tbody>
        <%
          Controladora controladora = (Controladora) sesion.getAttribute("controladora");

          List<Entrada> listaEntradas = controladora.encontrarEntradas();

          for (Entrada ent : listaEntradas) {
              
                if(ent.getDiaAIr().equals(dia)) {
        %>

        <tr>
          <td><%=ent.getIdEntrada()%></td>
          <td><%=ent.getDiaAIr()%></td>
          <td><%=ent.getCli().getIdTarjeta()%></td>
          <td><%=ent.getAtr().getNombreAtraccion()%></td>
          <td><%=ent.getHor().getPrincipio()%></td>
          <td><%=ent.getHor().getFin()%></td>
        </tr>

        <%} }%>   
    </div>
    
        <!-- ----------------------------------------------------------------------->
    
    
        <div>
            <table>
                <caption>Entradas vendidas |Juego: <%=atr.getNombreAtraccion()%> |Dia: <%=dia%>:</caption>>
      <thead>
        <tr>
          <th>ID</th>
          <th>Dia</th>
          <th>Id Tarjeta</th>
          <th>Nombre Atraccion</th>
          <th>Horario Entrada</th>
          <th>Horario Salida</th>
        </tr>
      </thead>
      <tbody>
        <%

          for (Entrada ent : listaEntradas) {
              
                if(ent.getDiaAIr().equals(dia) && ent.getAtr().getIdAtraccion() == atr.getIdAtraccion()) {
        %>

        <tr>
          <td><%=ent.getIdEntrada()%></td>
          <td><%=ent.getDiaAIr()%></td>
          <td><%=ent.getCli().getIdTarjeta()%></td>
          <td><%=ent.getAtr().getNombreAtraccion()%></td>
          <td><%=ent.getHor().getPrincipio()%></td>
          <td><%=ent.getHor().getFin()%></td>
        </tr>
        <%} }%>
            
        </div>
    
        
        
        <!-- ------------------------------------------------------------------------------ -->
        
        
        <div>
            <table>
                <caption>Juego: <%=atr.getNombreAtraccion()%> |Encargados:</caption>>
      <thead>
        <tr>
          <th>ID</th>
          <th>Apellido</th>
          <th>Nombre</th>
          <th>Atraccion</th>
          <th>Id Usuario</th>
        </tr>
      </thead>
      <tbody>
        <%
          List<Encargado> listaEncargados = atr.getListaEnc();
          for (Encargado enc : listaEncargados) {
              
                if(atr.getIdAtraccion() == enc.getAtr().getIdAtraccion()) {
        %>

        <tr>
          <td><%=enc.getIdEncargado()%></td>
          <td><%=enc.getApellido()%></td>
          <td><%=enc.getNombre()%></td>
          <td><%=enc.getAtr().getNombreAtraccion()%></td>
          <td><%=enc.getUser().getIdUsuario()%></td>
        </tr>
        <%} }%>
            
        </div>
    
        
        
        <%} else {

            response.sendRedirect("LoginError.jsp");

        }%>
        
      
    </body>
</html>
