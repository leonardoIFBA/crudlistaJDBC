import java.sql.Connection;

import model.Pessoa;
import repository.PessoaRepository;
import util.Conexao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Connection con = Conexao.getConexao();
        // criar uma instancia do repositorio
        PessoaRepository rep = new PessoaRepository();
        Pessoa p = new Pessoa(1, "leo", 40);
        Pessoa p1 = new Pessoa(2, "jesus", 40);
        Pessoa p2 = new Pessoa(3, "maria", 40);
        Pessoa p3 = new Pessoa(4, "jose", 40);
        // inserindo no BD
        /*rep.inserir(p);
        rep.inserir(p1);
        rep.inserir(p2);
        rep.inserir(p3);*/
        System.out.println(rep.listarTodos());
    }
}
