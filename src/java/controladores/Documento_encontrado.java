/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import datos.DAO.DocumentoDAO;
import datos.entidades.Documento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFBL
 */
@WebServlet(name = "Documento_encontrado", urlPatterns = {"/Documento_encontrado"})
public class Documento_encontrado extends HttpServlet {

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
            int tipo_doc1;
            String docu = request.getParameter("doc");
            String tipo_doc = request.getParameter("tipo_doc");
            String doc_usu_reporta = request.getParameter("doc_usu_denuncia");
            
            if (tipo_doc.equals("Cédula de ciudadanía"))
            {
                tipo_doc1 = 1;
            }
            if (tipo_doc.equals("Cédula de extranjería"))
            {
                tipo_doc1 = 2;
            }
            if (tipo_doc.equals("Tarjeta de identidad"))
            {
                tipo_doc1 = 3;
            }
            else
            {
                tipo_doc1 = 4;
            }
            
            Documento documento = new Documento();
            documento.setDocumento_usuario_reporta(doc_usu_reporta);
            documento.setId_documento(Integer.parseInt(docu));
            documento.setNo_documento(docu);
            documento.setId_estado(1);
            documento.setId_tipo_documento(tipo_doc1);
            DocumentoDAO docDAO = new DocumentoDAO();
            boolean exito = docDAO.save(documento);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Documento encontrado</title>");            
            out.println("</head>");
            out.println("<body>");
            if(exito)
            {
                out.println("<h1>Reporte guardado con éxito</h1>");
            }
            else
            {
                out.println("<h1>Reporte no guardado</h1>");
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
