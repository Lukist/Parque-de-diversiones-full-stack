
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/numberInput.css" rel="stylesheet" type="text/css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Registro de Usuario</h1>
            <form method="POST" action="UsuarioAtraccionNuevo" autocomplete="off">

                <div class="form-control">
                    <input type="text" name="nombreUsuario" id="nombreUsuario" required="">
                    <label>
                        <span style="transition-delay:0ms">U</span><span style="transition-delay:50ms">s</span><span style="transition-delay:100ms">e</span><span style="transition-delay:150ms">r</span><span style="transition-delay:200ms">n</span><span style="transition-delay:250ms">a</span><span style="transition-delay:300ms">m</span><span style="transition-delay:350ms">e</span>
                    </label>
                </div>

                <div class="form-control">
                    <input type="password" name="clave" id="clave" required="">
                    <label>
                        <span style="transition-delay:0ms">C</span><span style="transition-delay:50ms">l</span><span style="transition-delay:100ms">a</span><span style="transition-delay:150ms">v</span><span style="transition-delay:200ms">e</span>
                    </label>
                </div>

                <div class="form-control" >
                    <input type="text" name="nombre" id="nombre" required="">
                    <label>
                        <span style="transition-delay:0ms">N</span><span style="transition-delay:50ms">o</span><span style="transition-delay:100ms">m</span><span style="transition-delay:150ms">b</span><span style="transition-delay:200ms">r</span><span style="transition-delay:250ms">e</span>
                    </label>
                </div>

                <div class="form-control">
                    <input type="text" name="apellido" id="apellido" required="">
                    <label>
                        <span style="transition-delay:0ms">A</span><span style="transition-delay:50ms">p</span><span style="transition-delay:100ms">e</span><span style="transition-delay:150ms">l</span><span style="transition-delay:200ms">l</span><span style="transition-delay:250ms">i</span><span style="transition-delay:300ms">d</span><span style="transition-delay:350ms">o</span>
                    </label>
                </div>


                <div class="form-control">
                    <input type="text" name="nombreAtraccion" id="nombreAtraccion" required="">
                    <label>
                        <span style="transition-delay:0ms">A</span><span style="transition-delay:50ms">t</span><span style="transition-delay:100ms">r</span><span style="transition-delay:150ms">a</span><span style="transition-delay:200ms">c</span><span style="transition-delay:250ms">c</span><span style="transition-delay:300ms">i</span><span style="transition-delay:350ms">o</span><span style="transition-delay:400ms">n</span>
                    </label>
                </div>
                
                <div class="form-control">
                    <input type="number" name="capacidadMax" id="capacidadMax" required="">
                    <label>
                        <span style="transition-delay:0ms">C</span><span style="transition-delay:50ms">a</span><span style="transition-delay:100ms">p</span><span style="transition-delay:150ms">a</span><span style="transition-delay:200ms">c</span><span style="transition-delay:250ms">i</span><span style="transition-delay:300ms">d</span><span style="transition-delay:350ms">a</span><span style="transition-delay:400ms">d</span><span style="transition-delay:450ms"> </span><span style="transition-delay:450ms">M</span><span style="transition-delay:500ms">a</span><span style="transition-delay:550ms">x</span>
                    </label>
                </div>
                
                <div class="form-control">
                    <input type="number" name="capacidadMin" id="capacidadMin" required="">
                    <label>
                        <span style="transition-delay:0ms">C</span><span style="transition-delay:50ms">a</span><span style="transition-delay:100ms">p</span><span style="transition-delay:150ms">a</span><span style="transition-delay:200ms">c</span><span style="transition-delay:250ms">i</span><span style="transition-delay:300ms">d</span><span style="transition-delay:350ms">a</span><span style="transition-delay:400ms">d</span><span style="transition-delay:450ms"> </span><span style="transition-delay:450ms">M</span><span style="transition-delay:500ms">i</span><span style="transition-delay:550ms">n</span>
                    </label>
                </div>
                
                <div class="chekBox">
                    <label class="checkTitle">Mayoria de Edad</label>
                    <input type="radio" name="mayoriaEdad" id="mayoriaEdad" required="" value="true">
                    <label for="mayoriaEdad">Si</label>
                    <input type="radio" name="mayoriaEdad" id="minoriaEdad" required="" value="false">
                    <label for="minoriaEdad">No</label>
                </div>
                
                <div class="form-control">
                    <label>Hora Inicio</label><br>
                    <input type="time" name="horaIda" id="horaIda" required="" class="date">
                    
                </div>
                
                <div class="form-control">
                    <label>Hora Final</label><br>
                    <input type="time" name="horaVuelta" id="horaVuelta" required="" class="date">  
                </div>
                <div class="linkContainer">
                    <input type="submit" value="submit" class="submit">
                </div>
                
                
            </div>   
        </form>
            
            
        
    </body>
</html>
