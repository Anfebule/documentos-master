/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import datos.DAO.Usuario_denunciaDAO;
import datos.DAO.Usuario_reportaDAO;
import datos.entidades.Usuario_denuncia;
import datos.entidades.Usuario_reporta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFBL
 */
@WebServlet(name = "Agregar_usuario", urlPatterns = {"/Agregar_usuario"})
public class Agregar_usuario extends HttpServlet {

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
            
            String documento = request.getParameter("doc");
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            Date fecha = Date.valueOf(request.getParameter("fecha"));
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            
            Usuario_denuncia usuden = new Usuario_denuncia();
            usuden.setApellido1(apellido1);
            usuden.setApellido2(apellido2);
            usuden.setCorreo(correo);
            usuden.setDireccion(direccion);
            usuden.setDocumento_usuario_denuncia(documento);
            usuden.setFecha_nacimiento(fecha);
            usuden.setNombres(nombre);
            usuden.setTelefono(telefono);
            Usuario_denunciaDAO usudenDAO = new Usuario_denunciaDAO();
            boolean exito = usudenDAO.save(usuden);
            
            Usuario_reporta usurep = new Usuario_reporta();
            usurep.setApellido1(apellido1);
            usurep.setApellido2(apellido2);
            usurep.setCorreo(correo);
            usurep.setDireccion(direccion);
            usurep.setDocumento_usuario_reporta(documento);
            usurep.setNombres(nombre);
            usurep.setTelefono(telefono);
            Usuario_reportaDAO usurepDAO = new Usuario_reportaDAO();
            boolean exito1 = usurepDAO.save(usurep);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            if (exito && exito1)
            {
                out.println("<h1>Usuario agregado con éxito</h1>");
            }
            else
            {
                out.println("<h1>Usuario no agregado</h1>");
            }
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
        processRequest(request, response);
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
