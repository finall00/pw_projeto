package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.Pessoa;
import utils.Conexao;

public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = Conexao.abrirConexao();
    }

    public Object buscarPessoa(String cpfPessoa) throws SQLException {
        String sql = "select codigopessoa, nomepessoa, datanascimentopessoa from pessoa where cpfpessoa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpfPessoa);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa(rs.getInt("codigopessoa"), rs.getString("nomepessoa"), new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("datanascimentopessoa")), null, null);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar pessoa");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return pessoa;
    }

}

