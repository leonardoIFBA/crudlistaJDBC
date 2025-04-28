package repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pessoa> listarTodos(){
        // criar a lista que vai ser retornada
        List<Pessoa> pessoas = new ArrayList<>();
        // monta a consulta sql para inserir no BD
        String sql = "select * from pessoa";
        // preperar a conexao conexao e a consulta para execução
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
                // guarda em RS o resultado da consulta no BD
                ResultSet rs = ps.executeQuery();
                // percorre o RS e carrega na lista de Pessoas
                while (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));

                    // addicona a pessoa na lista
                    pessoas.add(p);                    
                }

            }catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return pessoas;
    }
}
