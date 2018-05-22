<%--
    Document   : RegistroPaciente
    Created on : 8/05/2018, 07:39:10 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="EstiloCitas.css">
        <title>Registro</title>
    </head>
    <body>
        <header>
            <div class="contenedor">
                <div id="marca">
                    <h1>
                        Registro de cita
                    </h1>                   
                </div>                                     
            </div>
        </header>
        <form class="registroPaciente" method="post" action="RegistroCita">                        
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input  type="text" class="login-input" id="numeroSeguridadSocial" name="nss"aria-describedby="emailHelp" placeholder="Número Seguridad Social">
            </div>                                               
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input type="text" class="login-input" id="nombrePaciente"  name="nombrePaciente"aria-describedby="emailHelp" placeholder="Nombre">
            </div>            
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input type="text" class="login-input" id="apellidos" name="apellidoPaciente" aria-describedby="emailHelp" placeholder="Apellidos">                                    
            </div>
            <div class="User-Login">
                <label for="exampleInputPassword1"></label>
                <input type="text" class="login-input" id="telefono" placeholder="Teléfono" name="telefono">
            </div>               
            <div class="User-Login">
                <label for="exampleInputPassword1"></label>
                <input type="text" class="login-input" id="descripcion" placeholder="Descripcion del malestar" name="descripcion">
            </div>
            <div class="fecha-input">
                fecha 
                <br>
                <input type="date" name="fecha" min="2018-03-25"
                       max="2019-12-25" step="1">                   
            </div>
            <div class="fecha-input">
                hora
                <br>
                <input type="time" name="hora" min="18:00"
                       max="21:00" step="3600">  
            </div>     
            <select name="medicosDisponibles">
                <option value="1">Medico 1</option> 
                <option value="2">Medico 2</option>                 
            </select> 
            <div>
                <input type="submit"  value="Pedir cita" class="login-button">
                <input type="hidden" name="action" value="RegistroPaciente" class="login-button">
            </div>            
        </form>
        <script src="JavaScript/Funciones.js"></script>
    </body>
</html>
