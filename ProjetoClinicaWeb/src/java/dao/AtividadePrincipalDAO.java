package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AtividadePrincipal;
import utils.Conexao;

public class AtividadePrincipalDAO implements DAOGenerica {

    private Connection conexao;

    public AtividadePrincipalDAO() throws ClassNotFoundException, SQLException {
        conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "call cadastrarAtividadePrincipal(?, ?)";
        AtividadePrincipal atividadePrincipal = (AtividadePrincipal) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, atividadePrincipal.getCodigoAtividadePrincipal());
            stmt.setString(2, atividadePrincipal.getDescricaoAtividadePrincipal());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar atividade principal");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from atividadeprincipal where codigoatividadeprincipal = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AtividadePrincipal atividadePrincipal = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                atividadePrincipal = new AtividadePrincipal(rs.getInt("codigoatividadeprincipal"), rs.getString("descricaoatividadeprincipal"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar atividade principal");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return atividadePrincipal;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from atividadeprincipal";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AtividadePrincipal atividadePrincipal = new AtividadePrincipal(rs.getInt("codigoatividadeprincipal"), rs.getString("descricaoatividadeprincipal"));
                lista.add(atividadePrincipal);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar atividade principal");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        String sql = "delete from atividadeprincipal where codigoatividadeprincipal = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir atividade principal");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}