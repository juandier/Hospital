/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BD.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leonardo
 */
@WebServlet(urlPatterns = {"/GestionCita"})
public class GestionCita extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionCita</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionCita at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String consultarMedico(ConexionBD conexion, String usuario, String contrasena) {
        String nombreMedico = "";
        String apellidoMedico = "";
        String idMedico = "";
        String cadena = "";
        String sql = "select medico.nombre,medico.apellidos,medico.id from login,medico where login.usuario ='"
                + usuario + "' and login.contrasena='" + contrasena + "' and login.idMedico = medico.id";
        ArrayList<String[]> consultaUsuario = conexion.consulta(sql);
        if (consultaUsuario.size() > 0) {
            for (String[] fila : consultaUsuario) {
                nombreMedico = fila[0];
                apellidoMedico = fila[1];
                idMedico = fila[2];
            }
        }
        cadena = nombreMedico + " " + apellidoMedico + "," + idMedico;
        return cadena;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tipoAccion = request.getParameter("action");
            if (tipoAccion.equalsIgnoreCase("iniciar")) {
                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("password");
                ConexionBD conexion = new ConexionBD("clinica");
                String sql = "select usuario from login where usuario ='"+usuario+"' and contrasena='"+contrasena+"'";
                ArrayList<String[]> consultaUsuario = conexion.consulta(sql);
                System.out.println("Tamaño del array: " + consultaUsuario.size());
                if (consultaUsuario.size() > 0) {
                    for (String[] fila : consultaUsuario) {
                        usuario = fila[0];
                    }
                    HttpSession misession = (HttpSession) request.getSession();
                    String infoMedico = consultarMedico(conexion, usuario, contrasena);
                    misession.setAttribute("doctor", infoMedico);
                    System.out.println("La sesion es: "+misession.getAttribute("doctor"));                    
                    response.sendRedirect("GestionCitas.jsp");

                } else {
                    response.sendRedirect("index.jsp");
                }
            }
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
