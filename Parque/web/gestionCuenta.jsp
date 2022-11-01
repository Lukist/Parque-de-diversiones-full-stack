
<%@page import="logica.Horario"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
      HttpSession sesion = request.getSession();

      Usuario usuario = (Usuario) sesion.getAttribute("usuarioValidado");

      if (usuario != null) {
         
        
    %>
    <h1>Modificar usuario</h1>
    <form method="POST" action="modificarHorario" autocomplete="off">
      <div>
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" readonly value="<%=usr.getIdHorario()%>">
      </div>
      <div>
        <label for="horaPrincipio">Hora Principio:</label>
        <input type="time" id="horaPrincipio" name="horaPrincipio" value="<%=usr.getPrincipio()%>">
      </div>
      <div>
        <label for="horaFin">Hora Fin:</label>
        <input type="time" id="horaFin" name="horaFin" value="<%=usr.getFin()%>">
      </div>
      <div>
        <label for="Atraccion">Atraccion:</label>
        <input type="number" id="Atraccion" name="Atraccion" value=<%if (usr.getAtra() != null) {
            out.print(usr.getAtra().getIdAtraccion());
        } else {
            out.print("");
        }%>>
      </div>
      <div>
        <input type="submit" value="Modificar">
      </div>
    </form>
      
    <%} else {

      response.sendRedirect("LoginError.jsp");

    }%>
    </body>
</html>
