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
                        Registro de pacientes
                    </h1>                   
                </div>                                     
            </div>
        </header>
        <form class="registroPaciente" method="post">            
            <h2>Datos personales</h2>
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input  type="text" class="login-input" id="numeroSeguridadSocial" aria-describedby="emailHelp" placeholder="Número Seguridad Social">
            </div>            
            <div class="User-Login">
                <label for="exampleInputPassword1"></label>
                <input type="password" class="login-input" id="contraseñaPaciente" placeholder="contraseña">
            </div>    

            <div class="User-Login">
                <label for="exampleInputPassword1"></label>
                <input type="password" class="login-input" id="repitaContraseña" placeholder="Confirme contraseña">
            </div>    
            <br>
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input type="text" class="login-input" id="nombrePaciente" aria-describedby="emailHelp" placeholder="Nombre">
            </div>
            <div class="User-Login">
                <label for="exampleInputEmail1"></label>
                <input type="text" class="login-input" id="apellidos" aria-describedby="emailHelp" placeholder="Apellidos">                                    
            </div>
            <div class="User-Login">
                <label for="exampleInputPassword1"></label>
                <input type="text" class="login-input" id="telefono" placeholder="Teléfono">
            </div>         
            <div>
                <input type="submit"  value="Registrarse" class="login-button" onclick="validarContraseñaPaciente()">
                <input type="hidden" name="action" value="RegistroPaciente" class="login-button">
            </div>
        </form>
        <script src="JavaScript/Funciones.js"></script>
    </body>
</html>
