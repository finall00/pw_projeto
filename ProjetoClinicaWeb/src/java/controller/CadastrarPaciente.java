package controller;

import dao.PacienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AtividadePrincipal;
import model.Paciente;

@WebServlet(name = "CadastrarPaciente", urlPatterns = {"/CadastrarPaciente"})
public class CadastrarPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            int codigoPessoa = request.getParameter("codigoPessoa").isEmpty() ? 0 : Integer.parseInt(request.getParameter("codigoPessoa"));
            String nomePessoa = request.getParameter("nomePessoa");
            String dataNascimentoPessoa = request.getParameter("dataNascimentoPessoa");
            String cpfPessoa = request.getParameter("cpfPessoa");
            String numeroCartaoSusPaciente = request.getParameter("numeroCartaoSusPaciente");
            boolean statusPaciente = request.getParameter("statusPaciente").equals("Ativo");
            int codigoAtividadePrincipal = Integer.parseInt(request.getParameter("codigoAtividadePrincipal"));

            Paciente paciente = new Paciente(numeroCartaoSusPaciente, statusPaciente, new AtividadePrincipal(codigoAtividadePrincipal), codigoPessoa, nomePessoa, dataNascimentoPessoa, cpfPessoa, cpfPessoa.replaceAll("[./-]", ""));
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.cadastrar(paciente);
            request.setAttribute("mensagem", "Gravado com sucesso!");

        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }

        request.getRequestDispatcher("ListarPaciente").forward(request, response);

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
