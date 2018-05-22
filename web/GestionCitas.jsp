<%-- 
    Document   : GestionCitas
    Created on : 21/05/2018, 03:10:55 PM
    Author     : Leonardo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="BD.ConexionBD"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestión de citas</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="EstiloCitas.css">        
    </head>
    <body>                 
        <header>
            <div id="imagenDoctor">
                <img src="Imagenes/doctor.png" width="90" height="90">    
                <label>
                    <% String[] arreglo = new String[2];
                        String cadena = (String) session.getAttribute("doctor");
                        System.out.println("Sesion de citas " + session.getAttribute("doctor"));
                        arreglo = cadena.split(",");
                        String nombreDoctor = arreglo[0];
                        out.print("Dr." + nombreDoctor);
                    %>
                </label>
            </div>
        </header>
        <div class="container">
            <h2>Citas pendientes</h2>        
            <form>                
                <input class="login-input" type="search" placeholder="Número de cita">
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Buscar</button>
            </form>            
            <div class="container">                                
                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Cita</h4>
                            </div>
                            <div class="modal-body">
                                <div class="fecha-input">
                                    fecha nueva                                     
                                    <input type="date" name="fecha" min="2018-03-25"
                                           max="2019-12-25" step="1">                   
                                </div>
                                <div class="fecha-input">
                                    hora nueva                                  
                                    <input type="time" name="hora" min="18:00"
                                           max="21:00" step="3600">  
                                </div>     
                                <label>Estado de la cita</label>
                                <select name="EstadoCita" title="Estado de la cita">                                  
                                    <option value="1">Aplazada</option> 
                                    <option value="1">Pendiente</option> 
                                    <option value="2">Finalizada</option>                 
                                </select>   
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" onclick="guardarContacto()">Actualizar cambios</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <p>Pacientes</p>            
            <table class="table">
                <thead>
                    <tr>
                        <th>Numero de cita</th>
                        <th>NSS</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Telefono</th>                                                
                    </tr>
                </thead>
                <tbody>
                    <%
                        ConexionBD conexion = new ConexionBD("clinica");
                        int idMedico = Integer.parseInt(arreglo[1]);
                        String sql = "select id,nss,nombre,apellidos,dia,hora,telefono from cita where idMedico=" + idMedico;
                        ArrayList<String[]> listaCitas = conexion.consulta(sql);                      
                    %>
                    <%for (String[] fila : listaCitas) {%>                                                                            
                    <tr>
                        <td><%=fila[0]%></td>
                        <td><%=fila[1]%></td>
                        <td><%=fila[2]%></td>
                        <td><%=fila[3]%></td>
                        <td><%=fila[4]%></td>
                        <td><%=fila[5]%></td>
                        <td><%=fila[6]%></td>
                    </tr>
                    <%}%>                    
                </tbody>
            </table>
        </div>
    </body>
</html>
