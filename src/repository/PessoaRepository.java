package repository;

import java.sql.*;

import model.Pessoa;
import util.Conexao;

public class PessoaRepository {
    // este método insere um objeto pessoa no BD
    public void inserir(Pessoa pessoa){        
        // pega uma conexao com o banco de dados
        try(Connection con = Conexao.getConexao()) {
            // monta a consulta sql para inserir no BD
            String sql = "insert into pessoa (id, nome, idade) values (?,?,?)";
            // preperar a consulta para execução
            try(PreparedStatement ps = con.prepareStatement(sql)){
                // carregar os parametros da consulta
                ps.setInt(1, pessoa.getId());
                ps.setString(2, pessoa.getNome());
                ps.setInt(3, pessoa.getIdade());
                // executa a consulta e retorna o numero de linhas afetadas
                int rs = ps.executeUpdate();
                if (rs > 0){
                    System.out.println("Nova pessoa cadastrada com sucesso!");
                }
                ps.close();
            }
            con.close();    
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

