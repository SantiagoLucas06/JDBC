package dao;

import domain.Cliente;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stm = connection.prepareStatement("INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE'), ?, ?)")) {
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        }
    }

    @Override
    public Cliente consultar(String codigo) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stm = connection.prepareStatement("SELECT * FROM TB_CLIENTE WHERE CODIGO = ?")) {
            stm.setString(1, codigo);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("ID"));
                    cliente.setCodigo(rs.getString("CODIGO"));
                    cliente.setNome(rs.getString("NOME"));
                    return cliente;
                }
            }
        }
        return null; // Retorna null se nenhum cliente for encontrado
    }

    @Override
    public Integer excluir(Cliente cliente) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stm = connection.prepareStatement("DELETE FROM TB_CLIENTE WHERE CODIGO = ?")) {
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        }
    }
}
