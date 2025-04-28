package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao(){
        Connection conexao = null;
        String url = "jdbc:mysql://localhost:3306/listacrud?createDatabaseIfNotExist=true";
        String usuario = "root";
        String senha = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Passei os parametros diretamente para a função
            //conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/listacrud?createDatabaseIfNotExist=true", "root", "");
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão efetuada com sucesso.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível se conectar ao banco");
            e.printStackTrace();
        }
        return conexao;
    }
}
