/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import datos.DAO.DenunciaDAO;
import datos.DAO.DocumentoDAO;
import datos.DAO.TipodocumentoDAO;
import datos.DAO.estadoDAO;
import datos.entidades.Denuncia;
import datos.entidades.Documento;
import datos.entidades.Tipodocumento;
import datos.entidades.estado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFBL
 */
@WebServlet(name = "Buscar_documento", urlPatterns = {"/Buscar_documento"})
public class Buscar_documento extends HttpServlet {

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
            String id_documento = request.getParameter("doc");
            //int tipo_documento;
            //int id_denuncia = Integer.parseInt(request.getParameter("id_denuncia"));
            //String doc_usuario = request.getParameter("usu_doc");
            //int estado;
            
            if(id_documento == null)
            {
                RequestDispatcher rd = request.getRequestDispatcher("Buscar_documento.jsp");
                rd.forward(request, response);
            }
            
            Documento documento = new Documento();
            documento.setId_documento(Integer.parseInt(id_documento));
            DocumentoDAO docDAO = new DocumentoDAO();
            documento = docDAO.findById(documento);
            
            Denuncia denuncia = new Denuncia();
            denuncia.setId_denuncia(documento.getId_denuncia());
            DenunciaDAO denDAO = new DenunciaDAO();
            denuncia = denDAO.findById(denuncia);
            
            estado Estado = new estado();
            Estado.setId_estado(documento.getId_estado());
            estadoDAO estDAO = new estadoDAO();
            estDAO.findById(Estado);
            
            Tipodocumento tipodoc = new Tipodocumento();
            tipodoc.setIdtipo(documento.getId_documento());
            TipodocumentoDAO TipDAO = new TipodocumentoDAO();
            tipodoc = TipDAO.findById(tipodoc);
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Buscar Documento</title>");            
            out.println("</head>");
            out.println("<body>");
            /*if(documento.getId_documento() == 1)
            {
                out.println("Tipo de documento: Cédula de ciudadanía");
            }
            if(documento.getId_documento() == 2)
            {
                out.println("Tipo de documento: Cédula de extranjería");
            }
            if(documento.getId_documento() == 3)
            {
                out.println("Tipo de documento: Tarjeta de Identidad");
            }
            if(documento.getId_documento() == 4)
            {
                out.println("Tipo de documento: Pasaporte");
            }
            if(documento.getId_documento() == 5)
            {
                out.println("Tipo de documento: Licencia de conducción");
            }
            */
            out.println("Tipo de documento: "+tipodoc.getNombre());
            out.println("Numero de documento: "+documento.getId_documento());
            out.println("Id denuncia: "+documento.getId_denuncia());
            out.println("Documento del funcionario: "+documento.getDocumento_funcionario());
            out.println("Documento del usuario que reporta: "+documento.getDocumento_usuario_reporta());
            out.println("Documento del usuario que denuncia: "+documento.getDocumento_usuario_denuncia());
            out.println("Estado: "+Estado.getNombre());
            out.println("Fecha denuncia: "+denuncia.getFecha_denuncia());
            out.println("Fecha perdida: "+denuncia.getFecha_perdida());
            out.println("Hora perdida: "+denuncia.getHora_perdida());
            
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
