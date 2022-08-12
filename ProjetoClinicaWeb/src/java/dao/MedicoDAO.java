package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Medico;
import utils.Conexao;

public class MedicoDAO implements DAOGenerica {

    private Connection conexao;

     public MedicoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = Conexao.abrirConexao();
    }

    
    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "call cadastrarMedico(?,?,?,?,?,?,?)";
        Medico medico = (Medico) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, medico.getCodigoPessoa());
            stmt.setString(2, medico.getNomePessoa());
            stmt.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(medico.getDataNascimentoPessoa()).getTime()));
            stmt.setString(4, medico.getCpfPessoa());
            stmt.setString(5, medico.getSenhaPessoa());
            stmt.setString(6, medico.getCrmMedico());
            stmt.setBoolean(7, medico.isStatusMedico());
            stmt.execute();
        } catch (SQLException | ParseException ex) {
            throw new SQLException("Erro ao gravar médico");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from medico me inner join pessoa pe on me.codigomedico = pe.codigopessoa where pe.codigopessoa = ? ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                medico = new Medico(rs.getString("crmmedico"), rs.getBoolean("statusmedico"), rs.getInt("codigomedico"), rs.getString("nomepessoa"), new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("datanascimentopessoa")), rs.getString("cpfpessoa"), rs.getString("senhapessoa"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar medico");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return medico;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from medico me inner join pessoa pe on me.codigomedico = pe.codigopessoa";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico(rs.getString("crmmedico"), rs.getBoolean("statusmedico"), rs.getInt("codigomedico"), rs.getString("nomepessoa"), new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("datanascimentopessoa")), rs.getString("cpfpessoa"), rs.getString("senhapessoa"));
                lista.add(medico);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar medico");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        String sql = "delete from medico where codigomedico = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir medico");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}
