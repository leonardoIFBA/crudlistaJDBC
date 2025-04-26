package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import util.Conexao;

public class PessoaRepository {

    // Método para inclusão de novas pessoas
    public void inserir(Pessoa pessoa){
                
        // Cria uma conexão com o banco de dados 
        try(Connection con = Conexao.getConexao()) {

            // Monta a instrução SQL do insert
            String sql = "insert into pessoa (id,nome,idade) values (?,?,?)";
            
            // Prepara a consulta para ser executada
            try(PreparedStatement ps = con.prepareStatement(sql)){
                // seta os valores dos parametros
                ps.setLong(1, pessoa.getId());
                ps.setString(2, pessoa.getNome());
                ps.setInt(3, pessoa.getIdade());

                //executa a consulta e retorna o número de linhas afetadas
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    System.out.println("Nova Pessoa inserida com sucesso");                
                } 
                // Fecha a conexao
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }

    public void alterar(Pessoa pessoa){
        
        // Aperceiçoando o codigo do try

        // Monta a instrução SQL
        String sql = "update pessoa set nome = ?, idade = ? where id = ?";
            
        // Prepara a consulta para ser executada
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setInt(3, pessoa.getId());

            //executa a consulta e retorna o número de linhas afetadas
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Pessoa alterada com sucesso");                
            } 
            // Fecha a conexao
            ps.close();
            con.close();           
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }

    public void excluir(int id){
        
        // Cria uma conexão com o banco de dados 
        //try(Connection con = Conexao.getConexao()) {

        // Monta a instrução SQL
        String sql = "delete from pessoa where id = ?";
        
        // Prepara a consulta para ser executada
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);

            //executa a consulta e retorna o número de linhas afetadas
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Pessoa excluida com sucesso");                         
            }   
                     
            // Fecha a conexao
            ps.close();
            con.close();           
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }

    public List<Pessoa> listarTodos() {
        // cira a lista de pessoas a ser retornada
        List<Pessoa> pessoas = new ArrayList<>();

        // Monta a instrução SQL
        String sql = "SELECT * FROM pessoa";
        
        // executar comandos SQL diretamente no banco de dados
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            //executa a consulta e retorna o número de linhas afetadas
            ResultSet rs = ps.executeQuery();
                
            while (rs.next()){
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));                      
                pessoas.add(p);
            }       
            // Fecha a conexao
            ps.close();
            con.close();                     
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public Pessoa buscarPorId(int idBusca) {
        // cira a a pessoa a ser retornada
        Pessoa p = new Pessoa();

        // Monta a instrução SQL
        String sql = "SELECT * FROM pessoa where id = ?";            
        // Prepara a consulta para ser executada
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, idBusca);
            
            //executa a consulta e retorna o número de linhas afetadas
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {                        
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                } else {
                    System.out.println("Pessoa com ID " + idBusca + " não encontrado.");
                    p = null;
                }    
            } 
            // Fecha a conexao
            ps.close();
            con.close();            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
}
