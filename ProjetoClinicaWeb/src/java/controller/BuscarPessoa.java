package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

@WebServlet(name = "BuscarPessoa", urlPatterns = {"/BuscarPessoa"})
public class BuscarPessoa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        try {
            String cpfPessoa = request.getParameter("cpfPessoa");
            PessoaDAO pessoaDAO = new PessoaDAO();
            Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Pessoa pessoa = (Pessoa) pessoaDAO.buscarPessoa(cpfPessoa);
            response.getWriter().write(json.toJson(pessoa));
        } catch (SQLException | ClassNotFoundException ex) {
            response.getWriter().write("\"erro\": " + ex.getMessage());
        }

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