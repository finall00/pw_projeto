package controller;

import dao.MedicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Medico;

@WebServlet(name = "CadastrarMedico", urlPatterns = {"/CadastrarMedico"})
public class CadastrarMedico extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int codigoPessoa = request.getParameter("codigoPessoa").isEmpty() ? 0 : Integer.parseInt(request.getParameter("codigoPessoa"));
            
            String nomePessoa = request.getParameter("nomePessoa");
            String dataNascimentoPessoa = request.getParameter("dataNascimentoPessoa");
            String cpfPessoa = request.getParameter("cpfPessoa");
            String crmMedico = request.getParameter("crmMedico");
            
            boolean statusMedico = request.getParameter("statusMedico").equals("Ativo");
            
            Medico medico = new Medico(crmMedico,
                    statusMedico,
                    codigoPessoa, nomePessoa,
                    dataNascimentoPessoa, cpfPessoa, cpfPessoa.replaceAll("[./-]", ""));
            
            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.cadastrar(medico);
            request.setAttribute("mensagem", "Gravado com sucesso");
            
        } catch (SQLException |ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarMedico").forward(request, response);
        
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
