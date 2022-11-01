<%-- 
    Document   : crearUsuario
    Created on : 22/09/2022, 02:34:00
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="crearHorario" autocomplete="off">
      <div>
        <label for="horaPrincipio">Hora Principio:</label>
        <input type="time" id="horaPrincipio" name="horaPrincipio" value="">
      </div>
      <div>
        <label for="horaFin">Hora Fin:</label>
        <input type="time" id="horaFin" name="horaFin" value="">
      </div>
      <div>
        <label for="Atraccion">Atraccion:</label>
        <input type="number" id="Atraccion" name="Atraccion" value="">
      </div>
      <div>
        <input type="submit" value="Modificar">
      </div>
    </form>
    </body>
</html>
