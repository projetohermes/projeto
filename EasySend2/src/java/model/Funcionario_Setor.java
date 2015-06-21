package model;

public class Funcionario_Setor {

    private int matricula;
    private String nome;
    private String setor;

    public Funcionario_Setor() {
    }

    public Funcionario_Setor(int matricula, String nome, String setor) {
        this.matricula = matricula;
        this.nome = nome;
        this.setor = setor;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
