
package controller;

import dao.AtividadePrincipalDAO;
import dao.PacienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultarPaciente", urlPatterns = {"/ConsultarPaciente"})
public class ConsultarPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int codigoPaciente = Integer.parseInt(request.getParameter("codigoPaciente"));
            PacienteDAO pacienteDAO = new PacienteDAO();
            AtividadePrincipalDAO atividadePrincipalDAO = new AtividadePrincipalDAO();
            request.setAttribute("paciente", pacienteDAO.consultar(codigoPaciente));
            request.setAttribute("atividadesPrincipais", atividadePrincipalDAO.listar());
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}