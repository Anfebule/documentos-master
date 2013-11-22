/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import datos.DAO.DenunciaDAO;
import datos.DAO.DocumentoDAO;
import datos.entidades.Denuncia;
import datos.entidades.Documento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFBL
 */
@WebServlet(name = "reportar_documento", urlPatterns = {"/reportar_documento"})
public class reportar_documento extends HttpServlet {

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
            
            Calendar now = Calendar.getInstance();
            
            int tipo_doc1;
            int docu = Integer.parseInt(request.getParameter("doc"));
            int id_denuncia = Integer.parseInt(request.getParameter("denuncia"));
            String doc_funcionario = request.getParameter("doc_funcionario");
            String tipo_doc = request.getParameter("tipo_doc");
            String doc_usu_denuncia = request.getParameter("doc_usu_denuncia");
            Date fecha_perdida = Date.valueOf(request.getParameter("fecha_perdida"));
            Time hora_perdida = Time.valueOf(request.getParameter("hora_perdida"));
            
            if (tipo_doc.equals("Cédula de ciudadanía"))
            {
                tipo_doc1 = 1;
            }
            else{ 
                if (tipo_doc.equals("Cédula de extranjería"))
                {
                    tipo_doc1 = 2;
                }
                else{
                    if (tipo_doc.equals("Tarjeta de identidad"))
                    {
                        tipo_doc1 = 3;
                    }
                    else
                    {
                        tipo_doc1 = 4;
                    }
                }
            }
            
            Documento documento = new Documento();
            documento.setNo_documento(String.valueOf(docu));
            documento.setId_documento(docu);
            documento.setDocumento_usuario_denuncia(doc_usu_denuncia);
            documento.setDocumento_usuario_reporta(doc_usu_denuncia);
            documento.setDocumento_funcionario(doc_funcionario);
            documento.setId_denuncia(id_denuncia);
            documento.setId_tipo_documento(tipo_doc1);
            documento.setId_estado(0);
            DocumentoDAO docDAO = new DocumentoDAO();
            Boolean exito = docDAO.save(documento);
            
            //Calendar calendar = GregorianCalendar.getInstance();
            
            int dia = Calendar.DATE;
            int mes = Calendar.MONTH+1;
            int anio = Calendar.YEAR;
            
            String fecha_actual = String.valueOf(anio+"-"+mes+"-"+dia);
            
            Denuncia denuncia = new Denuncia();
            denuncia.setFecha_denuncia(Date.valueOf(fecha_actual));
            denuncia.setFecha_perdida(fecha_perdida);
            denuncia.setHora_perdida(hora_perdida);
            denuncia.setId_denuncia(id_denuncia);
            DenunciaDAO denDAO = new DenunciaDAO();
            denDAO.save(denuncia);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Reportar documento</title>");            
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
