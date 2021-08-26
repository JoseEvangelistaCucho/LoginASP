
package com.controlador;

import com.modelo.AccederUsuario;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Nombre de Clase: AccesoLogin. Fecha: 29-09-2017. Version: 1.0. Copyright:
 * ITCA-FEPADE.
 *
 * @author Victor Alvarado
 */
public class AccesoLogin extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        if (request.getParameter("btnAcceder") != null) {
            Usuario usu = new Usuario();
            String user = request.getParameter("nombreUsuario");
            String clave = request.getParameter("clave");

            usu.setNombreUsuario(user);
            usu.setClave(clave);
            AccederUsuario login = new AccederUsuario();
            String estado;

            try {
                estado = login.login(usu);

                if ("true".equals(estado)) {

                    HttpSession objSesion = request.getSession();

                    if (usu.getTipoUsuario().equals("Administrador")) {
                        objSesion.setAttribute("usuario", user);
                        objSesion.setAttribute("nivel", "Administrador");
                        response.sendRedirect("jsp/vistaAdmin.jsp");
                    } else if (usu.getTipoUsuario().equals("Cliente")) {
                        objSesion.setAttribute("usuario", user);
                        objSesion.setAttribute("nivel", "Cliente");
                        response.sendRedirect("jsp/vistaCliente.jsp");
                    }
                }
            } catch (Exception ex) {
                response.sendRedirect("./jsp/error.jsp");
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
