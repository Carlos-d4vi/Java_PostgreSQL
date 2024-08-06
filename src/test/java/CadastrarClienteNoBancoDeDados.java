import Domain.Cliente;
import Services.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CadastrarClienteNoBancoDeDados {
    @Test
    public void cadastrarCliente() {
        Connectionfactory connectionFactory = new Connectionfactory("jdbc:postgresql://localhost:5432/postgrees_java", "postgres", "d4vi1234)");

        Menu menu = new Menu(connectionFactory.connect_to_db());

        menu.cadastrarCliente("clientes", "Carlos", 18);

        Assert.assertEquals("Carlos", menu.acharClientePorNome("Carlos"));
    }

    @Test
    public void listarTodosOsClientes(){
        Connectionfactory connectionFactory = new Connectionfactory("jdbc:postgresql://localhost:5432/postgrees_java", "postgres", "d4vi1234)");

        Menu menu = new Menu(connectionFactory.connect_to_db());

        ArrayList<Cliente> listaDeClientes =  menu.listarClientes();

        Assert.assertEquals(listaDeClientes.size() > 1, listaDeClientes.size() > 1);
    }

    @Test
    public void atualizarCliente(){
        Connectionfactory connectionFactory = new Connectionfactory("jdbc:postgresql://localhost:5432/postgrees_java", "postgres", "d4vi1234)");

        Menu menu = new Menu(connectionFactory.connect_to_db());

       Assert.assertTrue(menu.atualizarCliente(1, "João", 18));
    }
    @Test
    public void excluirCliente(){
        Connectionfactory connectionFactory = new Connectionfactory("jdbc:postgresql://localhost:5432/postgrees_java", "postgres", "d4vi1234)");

        Menu menu = new Menu(connectionFactory.connect_to_db());

        Assert.assertTrue(menu.excluirCliente(2));
    }
}
