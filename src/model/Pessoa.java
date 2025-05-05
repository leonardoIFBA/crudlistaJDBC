package model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;    

    public Pessoa() {
    }

    public Pessoa(int id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /** imprime os atributos do objeto **/
    @Override
    public String toString() {
        return "Pessoa : id=" + id + " nome=" + nome + " idade=" + idade ;
    }

    /** Gera um código hash para o objeto. Esse código é usado em estruturas de dados que dependem de hashing, 
     * como HashMap, para armazenar e recuperar elementos de maneira eficiente. **/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**   Define a lógica de igualdade entre objetos. Por padrão, esse método verifica se duas referências 
     * apontam para o mesmo objeto, mas pode ser sobrescrito para comparar valores internos de objetos.
     * Se equals() indicar que dois objetos são iguais, seus códigos hash devem ser os mesmos. **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id != other.id)
            return false;
        return true;
    }

       
    
}