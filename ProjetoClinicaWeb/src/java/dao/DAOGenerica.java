package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOGenerica {

    public void cadastrar(Object objeto) throws SQLException;

    public Object consultar(int codigo) throws SQLException;

    public List<Object> listar() throws SQLException;

    public void excluir(int codigo) throws SQLException;
}