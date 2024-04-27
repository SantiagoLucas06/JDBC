package dao;

import domain.Cliente;

import java.sql.SQLException;

public interface IClienteDAO {

    Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente cliente) throws SQLException;
}