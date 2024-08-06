package Services;

import Domain.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    Connection connection;
    public Menu(Connection dbConnection){
        connection = dbConnection;
    }

    public void cadastrarCliente(String nomeTabela, String nome, Integer idade) {
        String sql = "'"+ nome + "', '" + idade + "'";
        try{
            String query = String.format("insert into "+ nomeTabela +"(nome, idade) values("+ sql +")");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String acharClientePorNome(String nomeCliente) {
        try {
            // Código SQL com um parâmetro
            String query = "SELECT nome FROM clientes WHERE nome = ?";

            // Prepara o código SQL
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, nomeCliente);

            // Executa o código SQL
            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                String nome = results.getString("nome");
                System.out.println("Nome encontrado: " + nome);
                return nome;
            } else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cliente> listarClientes(){
        String sql = "select * from clientes;";

        ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();

        try {
          PreparedStatement pstm = connection.prepareStatement(sql);

          ResultSet rset = pstm.executeQuery();

          while (rset.next()){
              Cliente cliente = new Cliente(rset.getString("nome"),rset.getInt("idade"), rset.getInt("id"));

              listaDeClientes.add(cliente);
          }

            for (int i = 0; i < listaDeClientes.size(); i++) {
                System.out.println(
                        "informações do cLiente: Id: " + listaDeClientes.get(i).getId() + " - Nome: "
                        + listaDeClientes.get(i).getNome() + " - Idade: "
                        + listaDeClientes.get(i).getIdade());
            }
          return listaDeClientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean atualizarCliente(Integer idDoCliente, String novoNome, Integer novaIdade){
        try{
            String sql = "UPDATE clientes\n" +
                    "SET nome = '"+novoNome+"', idade = "+novaIdade+"\n" +
                    "WHERE id = "+idDoCliente+";";

            PreparedStatement pstm = connection.prepareStatement(sql);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente atualizado!");
                return true;
            } else {
                System.out.println("Cliente não encontrado!");
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean excluirCliente(Integer idDoCliente){
        String sql = "DELETE FROM clientes\n" +
                     "WHERE id = "+idDoCliente+";";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);

            int ArrowsAffected = pstm.executeUpdate();

            if (ArrowsAffected > 0){
                System.out.println("Cliente " + idDoCliente + "deletado!");
                return true;
            }else{
                System.out.println("Cliente não encontrado!");
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
