/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BD.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(urlPatterns = {"/RegistroCita"})
public class RegistroCita extends HttpServlet {

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
            System.out.println("paso por la linea 72 de Registro cita");
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
        System.out.println("hola");
        String tipoRespuesta = request.getParameter("action");        
        if (tipoRespuesta.equalsIgnoreCase("RegistroPaciente")) {
            String nombre = request.getParameter("nombrePaciente");
            String apellidos = request.getParameter("apellidoPaciente");
            String dia = request.getParameter("fecha");                
            Date fecha = Date.valueOf(dia);
            java.sql.Date sqlDate= new Date(fecha.getTime());
            String hora = request.getParameter("hora");
            String nss = request.getParameter("nss");
            Time time= Time.valueOf(LocalTime.parse(hora));
            String telefono = request.getParameter("telefono");
            String descripcion = request.getParameter("descripcion");
            String numeroMedico = request.getParameter("MedicosDisponibles");   
            System.out.println("paso por la linea 84 de Registro cita");
            int id=9;
            try {
                ConexionBD conexion = new ConexionBD("clinica");
                conexion.insertarCitas(fecha, time, nombre, apellidos, telefono, descripcion, nss, 1);                                
                response.sendRedirect("index.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistroCita.class.getName()).log(Level.SEVERE, null, ex);
            }
            processRequest(request, response);
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
