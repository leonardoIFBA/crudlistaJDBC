import model.Pessoa;
import repository.PessoaRepository;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Pessoa p = new Pessoa(1,"Leo",30);
        Pessoa p1 = new Pessoa(2,"Ana",30);
        Pessoa p2 = new Pessoa(3,"Lua",30);
        Pessoa p3 = new Pessoa();
        p3.setId(4);
        p3.setNome("Maria");
        p3.setIdade(20);

        PessoaRepository rep = new PessoaRepository();
        System.out.println(rep.listarTodos());
        System.out.println(rep.buscarPorId(1));

        /*rep.inserir(p);
        rep.inserir(p1);
        rep.inserir(p2);
        rep.inserir(p3); 
        
        //rep.inserir(p);
        System.out.println(rep.listarTodos());

        //rep.excluir(5);
        /*System.out.println(rep.buscarPorId(3));
        Pessoa pessoaExclui = rep.buscarPorId(3);
        rep.excluir(pessoaExclui.getId());
        
        Pessoa pessoaAlterar = rep.buscarPorId(1);
        pessoaAlterar.setNome("LEONARDO");
        rep.alterar(pessoaAlterar);

        System.out.println(rep.listarTodos());
        */
        
    }
}
