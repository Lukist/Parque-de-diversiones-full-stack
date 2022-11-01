

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Space+Mono&display=swap" rel="stylesheet">
        
        <link href="Css/submitStyle.css" rel="stylesheet" type="text/css"/>
        <link href="Css/FormStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Registro de Usuario</h1>
            <form method="POST" action="registrationComplete" autocomplete="off">

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

                <input type="submit" value="submit" class="submit">
                
            </div>   
        </form>
    </body>
</html>
