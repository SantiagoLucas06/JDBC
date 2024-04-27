package test;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteTest {

    @Test
    public void testCadastrarCliente() throws Exception {

        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Lucas Santiago");


        Integer qtd = dao.cadastrar(cliente);


        assertEquals("Falha ao cadastrar cliente", Integer.valueOf(1), qtd);


        Cliente clienteBD = dao.consultar(cliente.getCodigo());


        assertNotNull("Cliente não encontrado no banco de dados", clienteBD);
        assertNotNull("ID do cliente não deveria ser nulo", clienteBD.getId());
        assertEquals("Código do cliente não corresponde ao esperado", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Nome do cliente não corresponde ao esperado", cliente.getNome(), clienteBD.getNome());


        Integer qtdDel = dao.excluir(clienteBD);

        assertNotNull("Falha ao excluir cliente", qtdDel);
    }
}