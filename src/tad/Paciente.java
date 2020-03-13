package tad;


public class Paciente {
    //Atributos
    private String nome; 
    private int idade;
    
    //Contrutores
    public Paciente(){}
    public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    //Getters/Setters
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
    
    //Método toString sobrescrito para visualizar os atributos da classe 
    @Override
    public String toString(){
        return "Nome completo: " + nome + "\nIdade: " + idade;
    }
}
