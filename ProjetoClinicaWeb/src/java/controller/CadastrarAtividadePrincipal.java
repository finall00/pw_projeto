package controller;

import dao.AtividadePrincipalDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AtividadePrincipal;

@WebServlet(name = "CadastrarAtividadePrincipal", urlPatterns = {"/CadastrarAtividadePrincipal"})
public class CadastrarAtividadePrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            int codigoAtividadePrincipal = request.getParameter("codigoAtividadePrincipal").isEmpty() ? 0 : Integer.parseInt(request.getParameter("codigoAtividadePrincipal"));
            
            String descricaoAtividadePrincipal = request.getParameter("descricaoAtividadePrincipal");

            AtividadePrincipal atividadePrincipal = new AtividadePrincipal(codigoAtividadePrincipal, descricaoAtividadePrincipal);

            AtividadePrincipalDAO atividadePrincipalDao = new AtividadePrincipalDAO();

            atividadePrincipalDao.cadastrar(atividadePrincipal);

            request.setAttribute("mensagem", "Gravado com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarAtividadePrincipal").forward(request, response);
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
