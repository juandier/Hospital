<%-- 
    Document   : Citas
    Created on : 8/05/2018, 08:26:38 AM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="EstiloCitas.css">
        <title>Citas</title>
    </head>
    <body class="bodyLogin">              
        <section id="Login">
            <img id="imagenFondo" src="Imagenes/Login.jpg" alt="imgLoging"> 
            <form class="login" action="GestionCita" method="post">
                <h3 class="login-title">Login</h3>
                <div class="User-Login">
                    <input type="text" class="login-input" name="usuario" placeholder="Usuario" autofocus>
                </div>
                <div class="PassWord-Login">
                    <input type="password" class="login-input" name="password" placeholder="Contraseña">
                </div>                
                <div>
                    <input type="submit"  value="Iniciar" class="login-button">
                    <input type="hidden" name="action" value="iniciar" class="login-button">
                </div>                
            </form>            
        </section>                       
    </body>
</html>
