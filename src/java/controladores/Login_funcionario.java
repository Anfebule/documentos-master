/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import datos.DAO.AdministradorDAO;
import datos.DAO.FuncionarioDAO;
import datos.entidades.Administrador;
import datos.entidades.Funcionario;
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
@WebServlet(name = "Login_funcionario", urlPatterns = {"/Login_funcionario"})
public class Login_funcionario extends HttpServlet {

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
                        
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            
            Funcionario funcionario = new Funcionario();
            funcionario.setNumeroDocumento(usuario);
            funcionario.setClave(pass);
            FuncionarioDAO funDAO = new FuncionarioDAO();
            Funcionario funcionario1 = funDAO.findById(funcionario);
            
            if(funcionario1.getNumeroDocumento().equals(funcionario.getNumeroDocumento()) && funcionario1.getClave().equals(funcionario.getClave()))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login funcionario</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Ingreso correcto funcionario</h1>");
                out.println("</body>");
                out.println("</html>");
                //RequestDispatcher rd = request.getRequestDispatcher("index.html");
                //rd.forward(request, response);
            }
            else{
                Administrador administrador = new Administrador();
                administrador.setLogin(usuario);
                administrador.setClave(pass);
                AdministradorDAO admDAO = new AdministradorDAO();
                Administrador administrador1 = admDAO.findById(administrador);
                
                if(administrador1.getLogin().equals(administrador.getLogin()) && administrador1.getClave().equals(administrador.getClave()))
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Login funcionario</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Ingreso correcto Administrador</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    //RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    //rd.forward(request, response);
                }
                else
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Login funcionario</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Usuario y/o contraseña incorrectos</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            
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
